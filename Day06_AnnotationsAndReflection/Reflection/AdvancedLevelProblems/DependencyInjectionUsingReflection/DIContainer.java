package Day06_AnnotationsAndReflection.Reflection.AdvancedLevelProblems.DependencyInjectionUsingReflection;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class DIContainer {
    private Map<Class<?>, Object> objectCache = new HashMap<>();

    // Method to register a class with the DI container
    public <T> T getInstance(Class<T> clazz) throws Exception {
        // If object is already created, return from the cache
        if (objectCache.containsKey(clazz)) {
            return (T) objectCache.get(clazz);
        }

        // Create a new instance using reflection
        T instance = clazz.getDeclaredConstructor().newInstance();

        // Inject dependencies
        injectDependencies(instance);

        // Store the created instance in the cache
        objectCache.put(clazz, instance);

        return instance;
    }

    // Method to inject dependencies into the fields marked with @Inject
    private void injectDependencies(Object instance) throws IllegalAccessException, Exception {
        // Get all fields of the class
        Field[] fields = instance.getClass().getDeclaredFields();

        // Loop through the fields and inject dependencies
        for (Field field : fields) {
            // Check if the field is annotated with @Inject
            if (field.isAnnotationPresent(Inject.class)) {
                field.setAccessible(true); // Make the field accessible

                // Get the dependency (the type of the field)
                Object dependency = getInstance(field.getType());

                // Inject the dependency into the field
                field.set(instance, dependency);
            }
        }
    }
}

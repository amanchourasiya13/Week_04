package Day06_AnnotationsAndReflection.Reflection.AdvancedLevelProblems.CustomObjectMapper;

import java.lang.reflect.Field;
import java.util.Map;

public class ObjectMapper {

    // Method to map values from a Map to an object's fields
    public static <T> T toObject(Class<T> clazz, Map<String, Object> properties) {
        try {
            // Create a new instance of the class
            T instance = clazz.getDeclaredConstructor().newInstance();

            // Get all fields of the class (including private fields)
            Field[] fields = clazz.getDeclaredFields();

            // Iterate over each field
            for (Field field : fields) {
                // If the field exists in the Map, set its value
                if (properties.containsKey(field.getName())) {
                    // Make the field accessible if it is private
                    field.setAccessible(true);

                    // Get the value from the Map and set it to the field
                    Object value = properties.get(field.getName());

                    // Set the value to the field in the instance
                    field.set(instance, value);
                }
            }

            // Return the populated object
            return instance;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void main(String[] args) {
        // Define a map with values to populate an object
        Map<String, Object> properties = Map.of(
                "name", "John Doe",
                "age", 30,
                "salary", 50000.0
        );

        // Create a Person object from the map using reflection
        Person person = toObject(Person.class, properties);

        // Print the populated Person object
        if (person != null) {
            System.out.println(person);
        }
    }
}

class Person {
    private String name;
    private int age;
    private double salary;

    // Constructor
    public Person() {}

    // Overriding toString() method to display Person details
    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + ", salary=" + salary + "}";
    }
}

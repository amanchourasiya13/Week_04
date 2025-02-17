package Day06_AnnotationsAndReflection.Annotations.AdvanceLevelProblems.CustomCachingSystem_CacheResult;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class CacheManager {

    // Cache stored as a HashMap where the key is the method input and the value is the result
    private static final Map<String, Object> cache = new HashMap<>();

    // Method to retrieve cached result or compute and store it
    public static Object getCachedResult(Object object, Method method, Object[] args) {
        String cacheKey = generateCacheKey(method, args);

        // Check if the result is already in the cache
        if (cache.containsKey(cacheKey)) {
            System.out.println("Returning cached result for: " + cacheKey);
            return cache.get(cacheKey);
        }

        try {
            // If not cached, invoke the method and cache the result
            Object result = method.invoke(object, args);
            cache.put(cacheKey, result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // Helper method to generate a unique cache key based on the method and its arguments
    private static String generateCacheKey(Method method, Object[] args) {
        StringBuilder key = new StringBuilder(method.getName());
        if (args != null) {
            for (Object arg : args) {
                key.append("_").append(arg.hashCode());  // Using hashCode of arguments for uniqueness
            }
        }
        return key.toString();
    }
}

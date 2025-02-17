package Day06_AnnotationsAndReflection.Reflection.IntermediateLevelProblems.AccessAndModifyStaticFields;

import java.lang.reflect.Field;

public class Configuration {

    // Private static field
    private static String API_KEY = "initial-api-key";

    public static void main(String[] args) {
        try {
            // Access the Configuration class
            Class<?> configClass = Configuration.class;

            // Access the private static field 'API_KEY'
            Field apiKeyField = configClass.getDeclaredField("API_KEY");

            // Make the field accessible
            apiKeyField.setAccessible(true);

            // Print the original value of the static field
            System.out.println("Original API_KEY: " + API_KEY);

            // Modify the static field 'API_KEY'
            apiKeyField.set(null, "new-api-key");  // 'null' for static field

            // Print the modified value of the static field
            System.out.println("Modified API_KEY: " + API_KEY);

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}

package Day06_AnnotationsAndReflection.Reflection.AdvancedLevelProblems.GenerateJSON_Repesenation;

import java.lang.reflect.Field;

public class JsonConverter {

    // Method to convert an object to a JSON-like string
    public static String toJson(Object obj) {
        StringBuilder jsonString = new StringBuilder();

        // Check if the object is null
        if (obj == null) {
            return "{}";
        }

        // Get the class of the object
        Class<?> clazz = obj.getClass();

        // Start the JSON object
        jsonString.append("{");

        // Get all fields of the class (including private fields)
        Field[] fields = clazz.getDeclaredFields();

        // Iterate over each field
        for (int i = 0; i < fields.length; i++) {
            // Make the field accessible (in case it is private)
            fields[i].setAccessible(true);

            try {
                // Get the field name and value
                String fieldName = fields[i].getName();
                Object fieldValue = fields[i].get(obj);

                // Append the key-value pair in JSON format
                jsonString.append("\"").append(fieldName).append("\": ");

                // Handle the field value: if it's a string, add quotes around it; otherwise, just append it
                if (fieldValue instanceof String) {
                    jsonString.append("\"").append(fieldValue).append("\"");
                } else {
                    jsonString.append(fieldValue);
                }

                // Add a comma if it's not the last field
                if (i < fields.length - 1) {
                    jsonString.append(", ");
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        // Close the JSON object
        jsonString.append("}");

        return jsonString.toString();
    }

    public static void main(String[] args) {
        // Create a sample object
        Person person = new Person("John Doe", 30, 50000.0);

        // Convert the object to JSON-like string
        String json = toJson(person);

        // Print the JSON-like string
        System.out.println(json);
    }
}


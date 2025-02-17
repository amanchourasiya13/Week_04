package Day06_AnnotationsAndReflection.Annotations.AdvanceLevelProblems.CustomSerializationAnnotation_JsonField;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class JsonSerializer {

    // Method to serialize an object to JSON using annotations
    public static String toJson(Object obj) {
        Class<?> objClass = obj.getClass();
        Map<String, Object> jsonMap = new HashMap<>();

        // Iterate through all fields of the class
        for (Field field : objClass.getDeclaredFields()) {
            // Check if the field has the @JsonField annotation
            if (field.isAnnotationPresent(JsonField.class)) {
                // Get the annotation and the custom name for the JSON key
                JsonField jsonField = field.getAnnotation(JsonField.class);
                String jsonKey = jsonField.name();

                try {
                    // Make the field accessible and get its value
                    field.setAccessible(true);
                    Object fieldValue = field.get(obj);

                    // Add the field's value to the map with the custom JSON key
                    jsonMap.put(jsonKey, fieldValue);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        // Convert the map into a JSON string representation
        return mapToJson(jsonMap);
    }

    // Helper method to convert the map to a JSON string
    private static String mapToJson(Map<String, Object> map) {
        StringBuilder json = new StringBuilder("{");

        for (Map.Entry<String, Object> entry : map.entrySet()) {
            json.append("\"").append(entry.getKey()).append("\":");
            if (entry.getValue() instanceof String) {
                json.append("\"").append(entry.getValue()).append("\"");
            } else {
                json.append(entry.getValue());
            }
            json.append(",");
        }

        // Remove the last comma if there is one
        if (json.length() > 1) {
            json.deleteCharAt(json.length() - 1);
        }

        json.append("}");
        return json.toString();
    }

    public static void main(String[] args) {
        // Create a User object
        User user = new User("JohnDoe", 25, "john.doe@example.com");

        // Convert the User object to JSON
        String jsonString = JsonSerializer.toJson(user);
        System.out.println(jsonString);
    }
}

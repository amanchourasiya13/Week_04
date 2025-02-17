package Day02_Collections.MapInterface;

import java.util.HashMap;
import  java.util.Map;

public class MaxValueKey {

    public static void main(String[] args) {
        // Example map
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 10);
        map.put("B", 20);
        map.put("C", 15);

        // Find the key with the highest value
        String keyWithMaxValue = findKeyWithMaxValue(map);

        // Print the result
        System.out.println("Key with the highest value: " + keyWithMaxValue);
    }

    // Method to find the key with the maximum value
    public static String findKeyWithMaxValue(Map<String, Integer> map) {
        String maxKey = null;
        int maxValue = Integer.MIN_VALUE;

        // Iterate through the map
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxValue) {
                maxValue = entry.getValue();
                maxKey = entry.getKey();
            }
        }

        return maxKey;
    }
}

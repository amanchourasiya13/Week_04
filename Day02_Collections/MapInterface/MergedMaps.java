package Day02_Collections.MapInterface;

import java.util.Map;
import  java.util.HashMap;

public class MergedMaps {

    public static void main(String[] args) {
        // Example maps
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("A", 1);
        map1.put("B", 2);
        Map<String, Integer> map2 = new HashMap<>();
        map2.put("B", 3);
        map2.put("C", 4);

        // Merge the maps
        Map<String, Integer> mergedMap = mergeMaps(map1, map2);

        // Print the merged map
        System.out.println(mergedMap);
    }

    // Method to merge two maps and sum values if the key exists in both maps
    public static Map<String, Integer> mergeMaps(Map<String, Integer> map1, Map<String, Integer> map2) {
        Map<String, Integer> mergedMap = new HashMap<>();

        // Add all entries from the first map to the merged map
        mergedMap.putAll(map1);

        // Iterate through the second map and merge with the first
        for (Map.Entry<String, Integer> entry : map2.entrySet()) {
            mergedMap.merge(entry.getKey(), entry.getValue(), Integer::sum);
        }

        return mergedMap;
    }
}


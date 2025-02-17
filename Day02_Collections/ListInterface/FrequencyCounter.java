package Day02_Collections.ListInterface;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FrequencyCounter {

    // Method to count the frequency of each element in a list
    public static Map<String, Integer> countFrequency(List<String> inputList) {
        Map<String, Integer> frequencyMap = new HashMap<>();

        // Loop through each element in the list and update the frequency map
        for (String element : inputList) {
            frequencyMap.put(element, frequencyMap.getOrDefault(element, 0) + 1);
        }
        return frequencyMap;
    }

    public static void main(String[] args) {

        // Example input list
        List<String> stringList = List.of("apple", "banana", "apple", "orange");

        // Count the frequency of elements
        Map<String, Integer> result = countFrequency(stringList);

        // Output the result
        System.out.println("Frequency of elements: " + result);
    }
}

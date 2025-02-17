package Day02_Collections.ListInterface;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveDuplicates {

    // Method to remove duplicates while preserving order
    public static <T> List<T> removeDuplicates(List<T> inputList) {
        //    public static List<String> removeDuplicates(List<String> inputList) {
        Set<T> seen = new HashSet<>(); // To keep track of elements we've already seen
        List<T> resultList = new ArrayList<>(); // To store the result without duplicates
        for (T element : inputList) {
            // If the element has not been seen before, add it to the result list
            if (!seen.contains(element)) {
                seen.add(element);
                resultList.add(element);
            }
        }

        return resultList;
    }

    public static void main(String[] args) {

        // Example input list with duplicates
        List<String> stringList = new ArrayList<>();
        stringList.add("apple");
        stringList.add("banana");
        stringList.add("apple");
        stringList.add("orange");
        stringList.add("banana");

        System.out.println("Original List: " + stringList);

        // Remove duplicates while preserving order
        List<String> result = removeDuplicates(stringList);

        System.out.println("List after removing duplicates: " + result);
    }
}


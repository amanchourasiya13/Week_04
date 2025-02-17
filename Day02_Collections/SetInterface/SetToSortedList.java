package Day02_Collections.SetInterface;

import java.util.Set;
import  java.util.List;
import java.util.ArrayList;
import  java.util.HashSet;
import  java.util.Collections;


public class SetToSortedList {

    // Method to convert a HashSet to a sorted list

    // public static <T extends Comparable<T>> List<T> convertSetToSortedList(Set<T> set) {
    public static List<Integer> convertSetToSortedList(Set<Integer> set) {
        // Convert the HashSet to a List
        List<Integer> list = new ArrayList<>(set);

        // Sort the list in ascending order
        Collections.sort(list);

        return list;
    }

    public static void main(String[] args) {

        // Example HashSet
        Set<Integer> set = new HashSet<>();
        set.add(5);
        set.add(3);
        set.add(9);
        set.add(1);

        // Convert the set to a sorted list
        List<Integer> sortedList = convertSetToSortedList(set);

        // Output the sorted list
        System.out.println("Sorted List: " + sortedList);
    }
}

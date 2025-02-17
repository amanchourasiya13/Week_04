package Day02_Collections.SetInterface;

import java.util.HashSet;

import java.util.Set;

public class CompareSets {

    // Method to check if two sets are equal
    //public static boolean areSetsEqual(Set set1, Set set2) {
    public static <T> boolean areSetsEqual(Set<T> set1, Set<T> set2) {
        return set1.equals(set2); // Uses the built-in equals method of Set
    }

    public static void main(String[] args) {

        // Example sets
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        Set<Integer> set2 = new HashSet<>();
        set2.add(3);
        set2.add(2);
        set2.add(1);

        // Compare the two sets
        boolean result = areSetsEqual(set1, set2);

        // Output the result
        System.out.println("Are the sets equal?: " + result);
    }
}


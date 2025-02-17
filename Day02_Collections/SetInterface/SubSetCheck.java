package Day02_Collections.SetInterface;

import java.util.HashSet;
import java.util.Set;

public class SubSetCheck {

    // Method to check if set1 is a subset of set2
    public static <T> boolean isSubset(Set<T> set1, Set<T> set2) {
        return set2.containsAll(set1);  // Check if all elements of set1 are in set2
    }

    public static void main(String[] args) {

        // Example sets
        Set<Integer> set1 = new HashSet<>();
        set1.add(2);
        set1.add(3);

        Set<Integer> set2 = new HashSet<>();
        set2.add(1);
        set2.add(2);
        set2.add(3);
        set2.add(4);

        // Check if set1 is a subset of set2
        boolean result = isSubset(set1, set2);

        // Output the result
        System.out.println("Is set1 a subset of set2?:- " + result);
    }
}

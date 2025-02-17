package Day02_Collections.SetInterface;

import java.util.HashSet;
import java.util.Set;

public class SymmetricDifference {


    // Method to compute the symmetric difference of two sets
    public static <T> Set<T> symmetricDifference(Set<T> set1, Set<T> set2) {
        //  public static Set<Integer> sy(Set set1,Set set2){}

        Set<T> resultSet = new HashSet<>(set1);  // Start with a copy of set1
        resultSet.addAll(set2);  // Union of set1 and set2

        Set<T> intersectionSet = new HashSet<>(set1);  // Copy set1 for intersection
        intersectionSet.retainAll(set2);  // Retain common elements (intersection)

        resultSet.removeAll(intersectionSet);  // Remove intersection from union

        return resultSet;
    }

    public static void main(String[] args) {

        // Example sets
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        Set<Integer> set2 = new HashSet<>();
        set2.add(3);
        set2.add(4);
        set2.add(5);

        // Compute symmetric difference
        Set<Integer> symmetricDiff = symmetricDifference(set1, set2);
        System.out.println("Symmetric Difference: " + symmetricDiff);
    }
}


package Day02_Collections.SetInterface;

import java.util.HashSet;
import java.util.Set;

public class SetOperations {

    // Method to compute the Union of two sets
    //  public static Set<Integer> unionOp(Set set1, Set set2){
    public static <T> Set<T> union(Set<T> set1, Set<T> set2) {
        // Set<Integer> result=new HashSet<>(set1);
        Set<T> resultSet = new HashSet<>(set1);  // Start with a copy of set1
        resultSet.addAll(set2);  // Add all elements of set2
        return resultSet;
    }

    // Method to compute the intersection of two sets
    // public static Set<Integer> inter(Set set1, Set set2){
    public static <T> Set<T> intersection(Set<T> set1, Set<T> set2) {
        Set<T> resultSet = new HashSet<>(set1);  // Start with a copy of set1
        resultSet.retainAll(set2);  // Retain only the elements that are in both sets
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

        // Compute union
        Set<Integer> unionSet = union(set1, set2);
        System.out.println("Union: " + unionSet);

        // Compute intersection
        Set<Integer> intersectionSet = intersection(set1, set2);
        System.out.println("Intersection: " + intersectionSet);
    }
}

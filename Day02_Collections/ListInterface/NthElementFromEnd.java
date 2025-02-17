package Day02_Collections.ListInterface;

import java.util.LinkedList;

public class NthElementFromEnd {

    // Method to find the Nth element from the end of the list

    //    public static String findNthFromEnd(LinkedList<String> list, int N) {
    public static <T> T findNthFromEnd(LinkedList<T> list, int N) {
        if (list == null || list.size() < N) {
            return null; // If list is null or the size is less than N, return null
        }

        // Create two pointers: fast and slow
        T result = null;
        var slow = list.listIterator();
        var fast = list.listIterator();

        // Move fast pointer N steps ahead
        for (int i = 0; i < N; i++) {
            if (fast.hasNext()) {
                fast.next();
            } else {
                return null; // If N is greater than the list size, return null
            }
        }

        // Move both slow and fast pointers one step at a time until fast reaches the end
        while (fast.hasNext()) {
            fast.next();
            result = slow.next();
        }

        return result;
    }

    public static void main(String[] args) {

        // Example input linked list
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C");
        linkedList.add("D");
        linkedList.add("E");

        // Nth element from the end
        int N = 2;

        // Call method to find the Nth element from the end
        String nthElement = findNthFromEnd(linkedList, N);

        System.out.println("The " + N + "th element from the end is: " + nthElement);
    }
}

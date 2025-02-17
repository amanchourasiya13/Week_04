package Day02_Collections.ListInterface;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

public class NthElementFromEndTest {

    @Test
    public void testFindNthFromEndValid() {
        // Set up a sample LinkedList
        LinkedList<String> list = new LinkedList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");

        // Test case: Nth element from the end
        String result = NthElementFromEnd.findNthFromEnd(list, 2);

        // Expected result: "D" is the 2nd element from the end
         assertEquals("D",result," The 2nd element from end should be D.");

    }

    @Test
    public void testFindNthFromEndOutOfBounds() {
        // Set up a sample LinkedList
        LinkedList<String> list = new LinkedList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");

        // Test case: N greater than the size of the list
        String result = NthElementFromEnd.findNthFromEnd(list, 10);

        // Expected result: null since the list doesn't have 10 elements
        assertNull(result, "The result should be null when N is greater than the size of the list.");
    }

    @Test
    public void testFindNthFromEndNegativeN() {
        // Set up a sample LinkedList
        LinkedList<String> list = new LinkedList<>();
        list.add("A");
        list.add("B");
        list.add("C");

        // Test case: Negative N (invalid input)
        String result = NthElementFromEnd.findNthFromEnd(list, -1);

        // Expected result: null since negative indices are invalid
        assertNull(result, "The result should be null when N is negative.");
    }

    @Test
    public void testFindNthFromEndEmptyList() {
        // Test case: Empty list
        LinkedList<String> list = new LinkedList<>();

        // Test case: Nth element from the end on an empty list
        String result = NthElementFromEnd.findNthFromEnd(list, 2);

        // Expected result: null since the list is empty
        assertNull(result, "The result should be null when the list is empty.");
    }

    @Test
    public void testFindNthFromEndSingleElement() {
        // Test case: List with a single element
        LinkedList<String> list = new LinkedList<>();
        list.add("A");

        // Test case: Nth element from the end in a list with a single element
        String result = NthElementFromEnd.findNthFromEnd(list, 1);

        // Expected result: "A" is the 1st element from the end
        assertEquals("A", result, "The 1st element from the end should be A.");
    }
}

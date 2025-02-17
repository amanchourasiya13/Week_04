package Day02_Collections.ListInterface;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class ListReversalTest {

    // Test for ArrayList
    @Test
    public void testReverseArrayList() {
        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);

        List<Integer> expectedReversedList = new ArrayList<>();
        expectedReversedList.add(5);
        expectedReversedList.add(4);
        expectedReversedList.add(3);
        expectedReversedList.add(2);
        expectedReversedList.add(1);

        // Reverse the list using the method
        List<Integer> reversedList = ListReversal.reverseList(arrayList);

        // Assert that the reversed list matches the expected result
        assertEquals(expectedReversedList, reversedList);
    }

    // Test for LinkedList
    @Test
    public void testReverseLinkedList() {
        List<Integer> linkedList = new ArrayList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);

        List<Integer> expectedReversedList = new ArrayList<>();
        expectedReversedList.add(5);
        expectedReversedList.add(4);
        expectedReversedList.add(3);
        expectedReversedList.add(2);
        expectedReversedList.add(1);

        // Reverse the list using the method
        List<Integer> reversedList = ListReversal.reverseList(linkedList);

        // Assert that the reversed list matches the expected result
        assertEquals(expectedReversedList, reversedList);
    }

    // Test for empty list
    @Test
    public void testReverseEmptyList() {
        List<Integer> emptyList = new ArrayList<>();

        // Reverse the empty list
        List<Integer> reversedList = ListReversal.reverseList(emptyList);

        // Assert that reversing an empty list results in an empty list
        assertTrue(reversedList.isEmpty());
    }

    // Test for a list with one element
    @Test
    public void testReverseSingleElementList() {
        List<Integer> singleElementList = new ArrayList<>();
        singleElementList.add(10);

        List<Integer> expectedReversedList = new ArrayList<>();
        expectedReversedList.add(10);

        // Reverse the single element list
        List<Integer> reversedList = ListReversal.reverseList(singleElementList);

        // Assert that reversing a single-element list returns the same list
        assertEquals(expectedReversedList, reversedList);
    }
}

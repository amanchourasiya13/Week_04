package Day02_Collections.ListInterface;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class RemoveDuplicatesTest {

    // Test for List<String> to remove duplicates
    @Test
    public void testRemoveDuplicates() {
        List<String> stringList = new ArrayList<>();
        stringList.add("apple");
        stringList.add("banana");
        stringList.add("apple");
        stringList.add("orange");
        stringList.add("banana");

        List<String> expectedResult = new ArrayList<>();
        expectedResult.add("apple");
        expectedResult.add("banana");
        expectedResult.add("orange");

        // Call the removeDuplicates method
        List<String> result = RemoveDuplicates.removeDuplicates(stringList);

        // Assert that the result is as expected
        assertEquals(expectedResult, result, "The list after removing duplicates should preserve the original order.");
    }

    // Test for an empty list (no duplicates to remove)
    @Test
    public void testEmptyList() {
        List<String> emptyList = new ArrayList<>();

        // The expected result is still an empty list
        List<String> result = RemoveDuplicates.removeDuplicates(emptyList);

        // Assert that the result is an empty list
        assertTrue(result.isEmpty(), "The list should remain empty after removing duplicates.");
    }

    // Test for a list with one element (should not remove anything)
    @Test
    public void testSingleElementList() {
        List<String> singleElementList = new ArrayList<>();
        singleElementList.add("apple");

        // The result should be the same list since there is no duplicate
        List<String> result = RemoveDuplicates.removeDuplicates(singleElementList);

        // Assert that the result is the same as the input list
        assertEquals(singleElementList, result, "The list with a single element should not change.");
    }

    // Test for a list where all elements are identical
    @Test
    public void testIdenticalElements() {
        List<String> identicalList = new ArrayList<>();
        identicalList.add("apple");
        identicalList.add("apple");
        identicalList.add("apple");

        List<String> expectedResult = new ArrayList<>();
        expectedResult.add("apple");

        // Call the removeDuplicates method
        List<String> result = RemoveDuplicates.removeDuplicates(identicalList);

        // Assert that only one element remains after removing duplicates
        assertEquals(expectedResult, result, "The list with identical elements should result in a single element.");
    }
}

package Day02_Collections.ListInterface;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class FrequencyCounterTest {

    @Test
    public void testCountFrequency() {
        // Input list with some duplicate elements
        List<String> inputList = List.of("apple", "banana", "apple", "orange", "banana", "banana");

        // Expected output map with frequencies of each element
        Map<String, Integer> expectedFrequency = Map.of(
                "apple", 2,
                "banana", 3,
                "orange", 1
        );

        // Call the countFrequency method
        Map<String, Integer> result = FrequencyCounter.countFrequency(inputList);

        // Assert that the result matches the expected frequency map
        assertEquals(expectedFrequency, result, "The frequency map should match the expected one.");
    }

    @Test
    public void testCountFrequencyEmptyList() {
        // Input list is empty
        List<String> inputList = List.of();

        // Expected output map should be empty
        Map<String, Integer> expectedFrequency = Map.of();

        // Call the countFrequency method
        Map<String, Integer> result = FrequencyCounter.countFrequency(inputList);

        // Assert that the result is an empty map
        assertEquals(expectedFrequency, result, "The frequency map should be empty for an empty list.");
    }

    @Test
    public void testCountFrequencySingleElement() {
        // Input list with a single element repeated
        List<String> inputList = List.of("apple", "apple", "apple");

        // Expected output map with a frequency of 3 for "apple"
        Map<String, Integer> expectedFrequency = Map.of(
                "apple", 3
        );

        // Call the countFrequency method
        Map<String, Integer> result = FrequencyCounter.countFrequency(inputList);

        // Assert that the result matches the expected frequency map
        assertEquals(expectedFrequency, result, "The frequency map should show 'apple' with a count of 3.");
    }

    @Test
    public void testCountFrequencyMultipleUniqueElements() {
        // Input list with unique elements
        List<String> inputList = List.of("apple", "banana", "orange");

        // Expected output map with frequency of 1 for each element
        Map<String, Integer> expectedFrequency = Map.of(
                "apple", 1,
                "banana", 1,
                "orange", 1
        );

        // Call the countFrequency method
        Map<String, Integer> result = FrequencyCounter.countFrequency(inputList);

        // Assert that the result matches the expected frequency map
        assertEquals(expectedFrequency, result, "The frequency map should show each element with a count of 1.");
    }
}

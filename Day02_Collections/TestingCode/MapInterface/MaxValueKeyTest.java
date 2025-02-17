package Day02_Collections.MapInterface;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Map;
import java.util.HashMap;

public class MaxValueKeyTest {

    @Test
    public void testFindKeyWithMaxValue() {
        // Example map
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 10);
        map.put("B", 20);
        map.put("C", 15);

        // Call the method to find the key with the maximum value
        String maxKey = MaxValueKey.findKeyWithMaxValue(map);

        // Assertion to check that the correct key is returned
        assertEquals("B", maxKey, "The key with the highest value should be 'B'");
    }

    @Test
    public void testFindKeyWithMaxValueEmptyMap() {
        // Empty map
        Map<String, Integer> emptyMap = new HashMap<>();

        // Call the method with an empty map
        String maxKey = MaxValueKey.findKeyWithMaxValue(emptyMap);

        // Assert that the method returns null for an empty map
        assertNull(maxKey, "The result should be null for an empty map");
    }

    @Test
    public void testFindKeyWithMaxValueSingleElement() {
        // Map with a single element
        Map<String, Integer> singleElementMap = new HashMap<>();
        singleElementMap.put("A", 5);

        // Call the method with a single element
        String maxKey = MaxValueKey.findKeyWithMaxValue(singleElementMap);

        // Assert that the method returns the correct key
        assertEquals("A", maxKey, "The key with the highest value should be 'A'");
    }
}

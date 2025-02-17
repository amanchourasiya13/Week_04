package Day02_Collections.MapInterface;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class InvertMapTest {

    @Test
    public void testInvertMap() {
        // Original map
        Map<String, Integer> originalMap = new HashMap<>();
        originalMap.put("A", 1);
        originalMap.put("B", 2);
        originalMap.put("C", 1);

        // Invert the map
        Map<Integer, List<String>> invertedMap = InvertMap.invertMap(originalMap);

        // Assertions
        assertNotNull(invertedMap, "Inverted map should not be null");

        // Check that the values 1 and 2 are present as keys in the inverted map
        assertTrue(invertedMap.containsKey(1), "Inverted map should contain key 1");
        assertTrue(invertedMap.containsKey(2), "Inverted map should contain key 2");

        // Check the list of keys for value 1 (should be "A" and "C")
        List<String> listForOne = invertedMap.get(1);
        assertNotNull(listForOne, "List for key 1 should not be null");
        assertTrue(listForOne.contains("A"), "List for key 1 should contain 'A'");
        assertTrue(listForOne.contains("C"), "List for key 1 should contain 'C'");

        // Check the list of keys for value 2 (should be "B")
        List<String> listForTwo = invertedMap.get(2);
        assertNotNull(listForTwo, "List for key 2 should not be null");
        assertTrue(listForTwo.contains("B"), "List for key 2 should contain 'B'");

        // Ensure that no other values exist in the inverted map
        assertEquals(2, invertedMap.size(), "Inverted map should contain exactly 2 keys");
    }
}

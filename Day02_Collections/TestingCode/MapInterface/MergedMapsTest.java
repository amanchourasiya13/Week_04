package Day02_Collections.MapInterface;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Map;
import java.util.HashMap;

public class MergedMapsTest {

    @Test
    public void testMergeMaps() {
        // First map
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("A", 1);
        map1.put("B", 2);

        // Second map
        Map<String, Integer> map2 = new HashMap<>();
        map2.put("B", 3);
        map2.put("C", 4);

        // Merging the maps
        Map<String, Integer> mergedMap = MergedMaps.mergeMaps(map1, map2);

        // Define expected merged map
        Map<String, Integer> expectedMap = new HashMap<>();
        expectedMap.put("A", 1);
        expectedMap.put("B", 5); // 2 + 3 = 5
        expectedMap.put("C", 4);

        // Assert that the merged map matches the expected map
        assertEquals(expectedMap, mergedMap, "The merged map should match the expected result");
    }

    @Test
    public void testMergeMapsWithEmptyMap() {
        // First map (non-empty)
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("A", 1);

        // Second map (empty)
        Map<String, Integer> map2 = new HashMap<>();

        // Merging the maps
        Map<String, Integer> mergedMap = MergedMaps.mergeMaps(map1, map2);

        // Assert that the merged map is equal to map1
        assertEquals(map1, mergedMap, "The merged map should be equal to the first map when the second map is empty");
    }

    @Test
    public void testMergeMapsWithNoCommonKeys() {
        // First map (no common keys)
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("A", 1);

        // Second map (no common keys)
        Map<String, Integer> map2 = new HashMap<>();
        map2.put("B", 2);

        // Merging the maps
        Map<String, Integer> mergedMap = MergedMaps.mergeMaps(map1, map2);

        // Define expected merged map
        Map<String, Integer> expectedMap = new HashMap<>();
        expectedMap.put("A", 1);
        expectedMap.put("B", 2);

        // Assert that the merged map matches the expected map
        assertEquals(expectedMap, mergedMap, "The merged map should include all keys when there are no common keys");
    }

    @Test
    public void testMergeMapsWithIdenticalKeys() {
        // First map with the same keys but different values
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("A", 10);

        // Second map with the same key and value to be summed
        Map<String, Integer> map2 = new HashMap<>();
        map2.put("A", 5);

        // Merging the maps
        Map<String, Integer> mergedMap = MergedMaps.mergeMaps(map1, map2);

        // Define expected merged map
        Map<String, Integer> expectedMap = new HashMap<>();
        expectedMap.put("A", 15); // 10 + 5 = 15

        // Assert that the merged map matches the expected map
        assertEquals(expectedMap, mergedMap, "The merged map should correctly sum the values for common keys");
    }
}

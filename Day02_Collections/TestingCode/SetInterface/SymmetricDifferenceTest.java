package Day02_Collections.SetInterface;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SymmetricDifferenceTest {

    @Test
    public void testSymmetricDifference() {
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        Set<Integer> set2 = new HashSet<>();
        set2.add(3);
        set2.add(4);
        set2.add(5);

        Set<Integer> expected = new HashSet<>();
        expected.add(1);
        expected.add(2);
        expected.add(4);
        expected.add(5);

        Set<Integer> actual = SymmetricDifference.symmetricDifference(set1, set2);

        // Asserting that the result matches the expected symmetric difference
        assertEquals(expected, actual, "The symmetric difference is incorrect.");
    }

    @Test
    public void testEmptySets() {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        Set<Integer> expected = new HashSet<>();

        Set<Integer> actual = SymmetricDifference.symmetricDifference(set1, set2);

        // Asserting that the result is an empty set
        assertEquals(expected, actual, "The symmetric difference of empty sets should be empty.");
    }

    @Test
    public void testNoCommonElements() {
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);

        Set<Integer> set2 = new HashSet<>();
        set2.add(3);
        set2.add(4);

        Set<Integer> expected = new HashSet<>();
        expected.add(1);
        expected.add(2);
        expected.add(3);
        expected.add(4);

        Set<Integer> actual = SymmetricDifference.symmetricDifference(set1, set2);

        // Asserting that the result is the union of the two sets
        assertEquals(expected, actual, "The symmetric difference of sets with no common elements should be their union.");
    }

    @Test
    public void testIdenticalSets() {
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        Set<Integer> set2 = new HashSet<>();
        set2.add(1);
        set2.add(2);
        set2.add(3);

        Set<Integer> expected = new HashSet<>();

        Set<Integer> actual = SymmetricDifference.symmetricDifference(set1, set2);

        // Asserting that the result is an empty set
        assertEquals(expected, actual, "The symmetric difference of identical sets should be empty.");
    }
}

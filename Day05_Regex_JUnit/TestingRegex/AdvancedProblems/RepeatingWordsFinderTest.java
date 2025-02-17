package Day05_Regex_JUnit.Regex.AdvancedProblems;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Set;

public class RepeatingWordsFinderTest {

    @Test
    public void testFindRepeatingWords() {
        // Test case 1: Example sentence with repeating words
        String input1 = "This is is a repeated repeated word test.";
        Set<String> result1 = RepeatingWordsFinder.findRepeatingWords(input1);
        assertEquals(2, result1.size());
        assertTrue(result1.contains("is"));
        assertTrue(result1.contains("repeated"));

        // Test case 2: Sentence with no repeating words
        String input2 = "This is a unique test.";
        Set<String> result2 = RepeatingWordsFinder.findRepeatingWords(input2);
        assertTrue(result2.isEmpty());

        // Test case 3: Sentence with all words repeating
        String input3 = "apple apple banana banana cherry cherry";
        Set<String> result3 = RepeatingWordsFinder.findRepeatingWords(input3);
        assertEquals(3, result3.size());
        assertTrue(result3.contains("apple"));
        assertTrue(result3.contains("banana"));
        assertTrue(result3.contains("cherry"));
    }
}

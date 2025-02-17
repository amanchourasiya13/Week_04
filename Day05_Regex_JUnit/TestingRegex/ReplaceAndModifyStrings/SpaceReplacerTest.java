package Day05_Regex_JUnit.Regex.ReplaceAndModifyStrings;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SpaceReplacerTest {

    @Test
    public void testReplaceMultipleSpaces() {
        // Test with multiple spaces between words
        String input1 = "This    is   an    example  with multiple   spaces.";
        String expected1 = "This is an example with multiple spaces.";
        String result1 = SpaceReplacer.replaceMultipleSpaces(input1);
        assertEquals(expected1, result1);

        // Test with a single space between words (should remain unchanged)
        String input2 = "This is a test.";
        String expected2 = "This is a test.";
        String result2 = SpaceReplacer.replaceMultipleSpaces(input2);
        assertEquals(expected2, result2);

        // Test with leading and trailing spaces
        String input3 = "  This    is   an    example.   ";
        String expected3 = " This is an example. ";
        String result3 = SpaceReplacer.replaceMultipleSpaces(input3);
        assertEquals(expected3, result3);

        // Test with only spaces
        String input4 = "     ";
        String expected4 = " ";
        String result4 = SpaceReplacer.replaceMultipleSpaces(input4);
        assertEquals(expected4, result4);

        // Test with no spaces
        String input5 = "NoSpacesHere";
        String expected5 = "NoSpacesHere";
        String result5 = SpaceReplacer.replaceMultipleSpaces(input5);
        assertEquals(expected5, result5);
    }
}

package Day05_Regex_JUnit.Regex.ReplaceAndModifyStrings;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CensorBadWordsTest {

    @Test
    public void testCensorBadWords() {
        // Test case with multiple bad words
        String input1 = "This is a damn bad example with some stupid words.";
        String[] badWords1 = {"damn", "stupid"};
        String expected1 = "This is a **** bad example with some **** words.";
        String result1 = CensorBadWords.censorBadWords(input1, badWords1);
        assertEquals(expected1, result1);

        // Test case with no bad words in the input
        String input2 = "This is a clean sentence.";
        String[] badWords2 = {"damn", "stupid"};
        String expected2 = "This is a clean sentence.";
        String result2 = CensorBadWords.censorBadWords(input2, badWords2);
        assertEquals(expected2, result2);

        // Test case with bad words not at word boundaries
        String input3 = "Thedamnthing is stupidly said.";
        String[] badWords3 = {"damn", "stupid"};
        String expected3 = "Thedamnthing is stupidly said.";
        String result3 = CensorBadWords.censorBadWords(input3, badWords3);
        assertEquals(expected3, result3);

        // Test case with only bad words
        String input4 = "damn stupid damn";
        String[] badWords4 = {"damn", "stupid"};
        String expected4 = "**** **** ****";
        String result4 = CensorBadWords.censorBadWords(input4, badWords4);
        assertEquals(expected4, result4);

        // Test case with case-insensitive matching
        String input5 = "This is a Damn and Stupid statement.";
        String[] badWords5 = {"damn", "stupid"};
        String expected5 = "This is a **** and **** statement.";
        String result5 = CensorBadWords.censorBadWords(input5, badWords5);
        assertEquals(expected5, result5);
    }
}

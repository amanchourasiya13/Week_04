import Day05_Regex_JUnit.Regex.ExtractionProblems.CapitalizedWordsExtractor;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;

public class CapitalizedWordsExtractorTest {

    @Test
    public void testExtractCapitalizedWords() {
        // Input text
        String text = "The Eiffel Tower is in Paris and the Statue of Liberty is in New York.";

        // Expected number of capitalized words
        int expectedCount = 8;  // Adjust this based on your observations
        List<String> capitalizedWords = CapitalizedWordsExtractor.extractCapitalizedWords(text);

        // Assert that the extracted words match the expected count
        assertEquals(expectedCount, capitalizedWords.size());

        // Optionally, you can also assert the actual words extracted
        assertEquals(List.of("The", "Eiffel", "Tower", "Paris", "Statue", "Liberty", "New", "York"), capitalizedWords);
    }
}

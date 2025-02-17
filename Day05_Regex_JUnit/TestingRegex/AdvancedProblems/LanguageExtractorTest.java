package Day05_Regex_JUnit.Regex.AdvancedProblems;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class LanguageExtractorTest {

    @Test
    public void testExtractLanguages() {
        // Test input with multiple languages
        String text = "I love Java, Python, and JavaScript, but I haven't tried Go yet.";
        List<String> expectedLanguages = List.of("Java", "Python", "JavaScript", "Go");
        List<String> extractedLanguages = LanguageExtractor.extractLanguages(text);
        assertEquals(expectedLanguages, extractedLanguages);

        // Test input with no languages
        String textNoLanguages = "I love coding in different languages.";
        List<String> expectedNoLanguages = List.of();
        List<String> extractedNoLanguages = LanguageExtractor.extractLanguages(textNoLanguages);
        assertEquals(expectedNoLanguages, extractedNoLanguages);

        // Test input with only one language
        String textOneLanguage = "I love Java.";
        List<String> expectedOneLanguage = List.of("Java");
        List<String> extractedOneLanguage = LanguageExtractor.extractLanguages(textOneLanguage);
        assertEquals(expectedOneLanguage, extractedOneLanguage);
    }
}

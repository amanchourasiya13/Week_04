package Day05_Regex_JUnit.Regex.ExtractionProblems;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.ArrayList;
import java.util.List;

public class CapitalizedWordsExtractor {

    public static List<String> extractCapitalizedWords(String text) {
        // Regular expression to match capitalized words
        String regex = "\\b[A-Z][a-z]+\\b";  // Adjusted to only capture words starting with a capital and followed by lowercase letters

        // Create a Pattern object
        Pattern pattern = Pattern.compile(regex);

        // Create a matcher object
        Matcher matcher = pattern.matcher(text);

        // List to hold all found capitalized words
        List<String> capitalizedWords = new ArrayList<>();

        // Find all matches and add them to the list
        while (matcher.find()) {
            capitalizedWords.add(matcher.group());
        }

        return capitalizedWords;
    }

    public static void main(String[] args) {
        // Example text
        String text = "The Eiffel Tower is in Paris and the Statue of Liberty is in New York.";

        // Extract capitalized words from the text
        List<String> words = extractCapitalizedWords(text);

        // Print all found capitalized words
        for (String word : words) {
            System.out.println(word);
        }
    }
}

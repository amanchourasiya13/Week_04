package Day05_Regex_JUnit.Regex.AdvancedProblems;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.ArrayList;
import java.util.List;

public class LanguageExtractor {

    public static List<String> extractLanguages(String text) {
        // Regular expression to match common programming languages
        String regex = "\\b(Java|Python|JavaScript|Go)\\b";

        // Create a Pattern object
        Pattern pattern = Pattern.compile(regex);

        // Create a matcher object
        Matcher matcher = pattern.matcher(text);

        // List to hold the found languages
        List<String> languages = new ArrayList<>();

        // Find all matches and add them to the list
        while (matcher.find()) {
            languages.add(matcher.group());
        }

        return languages;
    }

    public static void main(String[] args) {
        // Example text
        String text = "I love Java, Python, and JavaScript, but I haven't tried Go yet.";

        // Extract languages from the text
        List<String> languages = extractLanguages(text);

        // Print the result
        System.out.println(String.join(", ", languages)); // Output: Java, Python, JavaScript, Go
    }
}

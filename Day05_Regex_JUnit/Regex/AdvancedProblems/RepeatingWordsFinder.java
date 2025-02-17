package Day05_Regex_JUnit.Regex.AdvancedProblems;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Set;
import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;

public class RepeatingWordsFinder {

    public static Set<String> findRepeatingWords(String sentence) {
        // Regular expression to match words
        String regex = "\\b\\w+\\b";

        // Create a Pattern object
        Pattern pattern = Pattern.compile(regex);

        // Create a matcher object
        Matcher matcher = pattern.matcher(sentence);

        // Map to count occurrences of each word
        Map<String, Integer> wordCount = new HashMap<>();

        // Find all words and count occurrences
        while (matcher.find()) {
            String word = matcher.group().toLowerCase(); // Case-insensitive matching
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        // Set to store repeating words
        Set<String> repeatingWords = new HashSet<>();

        // Find words that repeat (occur more than once)
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            if (entry.getValue() > 1) {
                repeatingWords.add(entry.getKey());
            }
        }

        return repeatingWords;
    }

    public static void main(String[] args) {
        // Example input
        String input = "This is is a repeated repeated word test.";

        // Find repeating words in the input
        Set<String> repeatingWords = findRepeatingWords(input);

        // Print the result, joining repeating words with a comma
        System.out.println(String.join(", ", repeatingWords)); // Output: is, repeated
    }
}

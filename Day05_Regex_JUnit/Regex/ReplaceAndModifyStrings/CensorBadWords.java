package Day05_Regex_JUnit.Regex.ReplaceAndModifyStrings;

public class CensorBadWords {

    public static String censorBadWords(String text, String[] badWords) {
        // Create a regular expression pattern that matches any of the bad words, case-insensitively
        String regex = "(?i)\\b(" + String.join("|", badWords) + ")\\b";  // (?i) makes it case-insensitive

        // Replace all occurrences of the bad words with "****"
        return text.replaceAll(regex, "****");
    }

    public static void main(String[] args) {
        // Example input text
        String input = "This is a damn bad example with some stupid words.";

        // List of bad words to censor
        String[] badWords = {"damn", "stupid"};

        // Censor bad words
        String output = censorBadWords(input, badWords);

        // Print the result
        System.out.println(output);
    }
}

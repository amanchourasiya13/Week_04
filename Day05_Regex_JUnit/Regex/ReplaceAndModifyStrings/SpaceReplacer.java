package Day05_Regex_JUnit.Regex.ReplaceAndModifyStrings;


public class SpaceReplacer {

    public static String replaceMultipleSpaces(String text) {
        // Regular expression to match multiple spaces and replace them with a single space
        return text.replaceAll("\\s+", " ");
    }

    public static void main(String[] args) {
        // Example input text
        String input = "This    is   an    example  with multiple   spaces.";

        // Replace multiple spaces with a single space
        String output = replaceMultipleSpaces(input);

        // Print the result
        System.out.println(output);
    }
}

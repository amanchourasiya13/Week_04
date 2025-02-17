package Day05_Regex_JUnit.Regex.AdvancedProblems;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.ArrayList;
import java.util.List;


public class CurrencyExtractor {

    public static List<String> extractCurrencyValues(String text) {
        // Regular expression to match currency values
        String regex = "\\$?\\d+(\\.\\d{1,2})?";

        // Create a Pattern object
        Pattern pattern = Pattern.compile(regex);

        // Create a matcher object
        Matcher matcher = pattern.matcher(text);

        // List to hold the found currency values
        List<String> currencies = new ArrayList<>();

        // Find all matches and add them to the list
        while (matcher.find()) {
            currencies.add(matcher.group());
        }

        return currencies;
    }

    public static void main(String[] args) {
        // Example text
        String text = "The price is $45.99, and the discount is 10.50.";

        // Extract currency values from the text
        List<String> currencies = extractCurrencyValues(text);

        // Print the result, joining them with a comma
        System.out.println(String.join(", ", currencies)); // Output: $45.99, 10.50
    }
}


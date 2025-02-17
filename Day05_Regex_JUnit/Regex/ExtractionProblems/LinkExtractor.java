package Day05_Regex_JUnit.Regex.ExtractionProblems;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.ArrayList;
import java.util.List;

public class LinkExtractor {

    public static List<String> extractLinks(String text) {
        // Regular expression to match URLs starting with http:// or https://
        String regex = "https?://[a-zA-Z0-9.-]+(?:/[a-zA-Z0-9./?&%=]*)?";

        // Create a Pattern object
        Pattern pattern = Pattern.compile(regex);

        // Create a matcher object
        Matcher matcher = pattern.matcher(text);

        // List to hold all found URLs
        List<String> links = new ArrayList<>();

        // Find all matches and add them to the list
        while (matcher.find()) {
            links.add(matcher.group());
        }

        return links;
    }

    public static void main(String[] args) {
        // Example text
        String text = "Visit https://www.google.com and http://example.org for more info.";

        // Extract links from the text
        List<String> links = extractLinks(text);

        // Print all found links
        for (String link : links) {
            System.out.println(link);
        }
    }
}


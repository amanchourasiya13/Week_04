package Day05_Regex_JUnit.Regex.ExtractionProblems;

import java.util.regex.*;
import java.util.ArrayList;
import java.util.List;

public class EmailExtractor {

    public static List<String> extractEmails(String text) {
        // Regular expression to match email addresses
        String regex = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}";

        // Create a Pattern object
        Pattern pattern = Pattern.compile(regex);

        // Create a matcher object
        Matcher matcher = pattern.matcher(text);

        // List to hold all the found email addresses
        List<String> emailList = new ArrayList<>();

        // Find all matches and add them to the list
        while (matcher.find()) {
            emailList.add(matcher.group());
        }

        return emailList;
    }

    public static void main(String[] args) {
        // Example text
        String text = "Contact us at support@example.com and info@company.org";

        // Extract emails from the text
        List<String> emails = extractEmails(text);

        // Print all found emails
        for (String email : emails) {
            System.out.println(email);
        }
    }
}


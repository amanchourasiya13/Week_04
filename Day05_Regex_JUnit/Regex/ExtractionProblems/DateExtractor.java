package Day05_Regex_JUnit.Regex.ExtractionProblems;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.ArrayList;
import java.util.List;

public class DateExtractor {

    public static List<String> extractDates(String text) {
        // Regular expression to match dates in dd/mm/yyyy format
        String regex = "\\b(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}\\b";

        // Create a Pattern object
        Pattern pattern = Pattern.compile(regex);

        // Create a matcher object
        Matcher matcher = pattern.matcher(text);

        // List to hold all found dates
        List<String> dates = new ArrayList<>();

        // Find all matches and add them to the list
        while (matcher.find()) {
            dates.add(matcher.group());
        }

        return dates;
    }

    public static void main(String[] args) {
        // Example text
        String text = "The events are scheduled for 12/05/2023, 15/08/2024, and 29/02/2020.";

        // Extract dates from the text
        List<String> dates = extractDates(text);

        // Print all found dates
        for (String date : dates) {
            System.out.println(date);
        }
    }
}


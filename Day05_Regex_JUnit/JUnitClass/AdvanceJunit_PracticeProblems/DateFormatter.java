package Day05_Regex_JUnit.JUnit.AdvanceJunit_PracticeProblems;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatter {

    // Method to convert yyyy-MM-dd format to dd-MM-yyyy
    public static String formatDate(String inputDate) {
        if (inputDate == null || inputDate.isEmpty()) {
            return "Invalid date format";  // Handle null or empty string
        }

        // Define the input and output date formats
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy");

        try {
            // Parse the input date to a Date object
            Date date = inputFormat.parse(inputDate);

            // Check if the parsed date is valid (i.e., not a logical incorrect date)
            String formattedDate = outputFormat.format(date);
            if (!inputFormat.format(date).equals(inputDate)) {
                return "Invalid date format";  // Return error if parsed date is logically incorrect
            }

            return formattedDate;
        } catch (ParseException e) {
            return "Invalid date format";  // Return error for parsing exceptions
        }
    }

    // Main method for direct testing
    public static void main(String[] args) {
        // Valid date test
        String validDate = "2025-02-15";
        String formattedDate = formatDate(validDate);
        System.out.println("Formatted date: " + formattedDate);  // Expected: 15-02-2025

        // Invalid date test (wrong format)
        String invalidDate = "15-02-2025";
        String invalidFormattedDate = formatDate(invalidDate);
        System.out.println("Formatted date: " + invalidFormattedDate);  // Expected: Invalid date format

        // Additional test cases
        System.out.println("Null input: " + formatDate(null));  // Expected: Invalid date format
        System.out.println("Empty input: " + formatDate(""));  // Expected: Invalid date format
        System.out.println("Nonexistent date: " + formatDate("2025-02-30"));  // Expected: Invalid date format
    }
}

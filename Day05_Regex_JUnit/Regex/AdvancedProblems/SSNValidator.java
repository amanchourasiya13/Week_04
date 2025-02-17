package Day05_Regex_JUnit.Regex.AdvancedProblems;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SSNValidator {

    public static boolean isValidSSN(String ssn) {
        // Regular expression to match the SSN format
        String regex = "^\\d{3}-\\d{2}-\\d{4}$";

        // Create a Pattern object
        Pattern pattern = Pattern.compile(regex);

        // Create a matcher object
        Matcher matcher = pattern.matcher(ssn);

        // Return true if SSN matches the regex, false otherwise
        return matcher.matches();
    }

    public static void main(String[] args) {
        // Example inputs
        String ssn1 = "123-45-6789";  // Valid SSN
        String ssn2 = "123456789";    // Invalid SSN (no hyphens)
        String ssn3 = "123-45-678";   // Invalid SSN (too short)
        String ssn4 = "123-45-67890"; // Invalid SSN (too long)

        // Validate the SSNs
        System.out.println(ssn1 + " is valid: " + isValidSSN(ssn1)); // true
        System.out.println(ssn2 + " is valid: " + isValidSSN(ssn2)); // false
        System.out.println(ssn3 + " is valid: " + isValidSSN(ssn3)); // false
        System.out.println(ssn4 + " is valid: " + isValidSSN(ssn4)); // false
    }
}

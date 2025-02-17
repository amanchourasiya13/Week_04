package Day05_Regex_JUnit.Regex.BasicRegexProblems;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LicensePlateValidator {

    public static boolean isValidLicensePlate(String licensePlate) {
        // Regular expression to validate the license plate format
        String regex = "^[A-Z]{2}[0-9]{4}$";

        // Create a Pattern object
        Pattern pattern = Pattern.compile(regex);

        // Create a matcher object
        Matcher matcher = pattern.matcher(licensePlate);

        // Return if the license plate matches the regex pattern
        return matcher.matches();
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(isValidLicensePlate("AB1234"));   // true
        System.out.println(isValidLicensePlate("A12345"));   // false (starts with only one letter)
        System.out.println(isValidLicensePlate("AB123"));    // false (only 3 digits)
        System.out.println(isValidLicensePlate("XY5678"));   // true
        System.out.println(isValidLicensePlate("ab1234"));   // false (letters are lowercase)
    }
}


package Day05_Regex_JUnit.Regex.BasicRegexProblems;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HexColorValidator {

    public static boolean isValidHexColor(String colorCode) {
        // Regular expression to validate the hex color code format
        String regex = "^#[0-9A-Fa-f]{6}$";

        // Create a Pattern object
        Pattern pattern = Pattern.compile(regex);

        // Create a matcher object
        Matcher matcher = pattern.matcher(colorCode);

        // Return if the color code matches the regex pattern
        return matcher.matches();
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(isValidHexColor("#FFA500"));  // true (valid)
        System.out.println(isValidHexColor("#ff4500"));  // true (valid)
        System.out.println(isValidHexColor("#123"));     // false (invalid, too short)
        System.out.println(isValidHexColor("#abcdef"));  // true (valid)
        System.out.println(isValidHexColor("#XYZ123"));  // false (invalid, non-hexadecimal characters)
    }
}

package Day05_Regex_JUnit.Regex.BasicRegexProblems;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
public class UsernameValidator {

    public static boolean isValidUsername(String username) {
        // Regular expression to validate the username
        String regex = "^[a-zA-Z][a-zA-Z0-9_]{4,14}$";

        // Create a Pattern object
        Pattern pattern = Pattern.compile(regex);

        // Create a matcher object
        Matcher matcher = pattern.matcher(username);

        // Return if the username matches the regex pattern
        return matcher.matches();
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(isValidUsername("user_123"));  // true
        System.out.println(isValidUsername("123user"));   // false
        System.out.println(isValidUsername("us"));        // false
        System.out.println(isValidUsername("valid_username")); // true
        System.out.println(isValidUsername("_invalid"));  // false
    }
}

package Day05_Regex_JUnit.Regex.AdvancedProblems;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class IPValidator {

    public static boolean isValidIP(String ip) {
        // Regular expression to validate IPv4 address
        String regex = "^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";

        // Create a Pattern object
        Pattern pattern = Pattern.compile(regex);

        // Create a matcher object
        Matcher matcher = pattern.matcher(ip);

        // Return true if the IP matches the regex, false otherwise
        return matcher.matches();
    }

    public static void main(String[] args) {
        // Example IP addresses
        String ip1 = "192.168.0.1";
        String ip2 = "256.256.256.256";
        String ip3 = "192.168.256.1";
        String ip4 = "0.0.0.0";

        // Test and validate the IP addresses
        System.out.println(ip1 + " is valid: " + isValidIP(ip1)); // true
        System.out.println(ip2 + " is valid: " + isValidIP(ip2)); // false
        System.out.println(ip3 + " is valid: " + isValidIP(ip3)); // false
        System.out.println(ip4 + " is valid: " + isValidIP(ip4)); // true
    }
}

package Day05_Regex_JUnit.Regex.AdvancedProblems;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class CreditCardValidator {

    public static boolean isValidCreditCard(String cardNumber) {
        // Regular expression to match Visa or MasterCard with 16 digits
        String regex = "^(4\\d{15}|5\\d{15})$";

        // Create a Pattern object
        Pattern pattern = Pattern.compile(regex);

        // Create a matcher object
        Matcher matcher = pattern.matcher(cardNumber);

        // Return true if the card number matches the regex, false otherwise
        return matcher.matches();
    }

    public static void main(String[] args) {
        // Example card numbers
        String card1 = "4111111111111111";  // Valid Visa card
        String card2 = "5111111111111111";  // Valid MasterCard
        String card3 = "411111111111111";   // Invalid (too short)
        String card4 = "51111111111111111"; // Invalid (too long)
        String card5 = "6111111111111111";  // Invalid (invalid starting digit)

        // Test and validate the card numbers
        System.out.println(card1 + " is valid: " + isValidCreditCard(card1)); // true
        System.out.println(card2 + " is valid: " + isValidCreditCard(card2)); // true
        System.out.println(card3 + " is valid: " + isValidCreditCard(card3)); // false
        System.out.println(card4 + " is valid: " + isValidCreditCard(card4)); // false
        System.out.println(card5 + " is valid: " + isValidCreditCard(card5)); // false
    }
}


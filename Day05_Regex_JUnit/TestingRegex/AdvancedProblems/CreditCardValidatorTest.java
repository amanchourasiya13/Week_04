package Day05_Regex_JUnit.Regex.AdvancedProblems;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CreditCardValidatorTest {

    @Test
    public void testIsValidCreditCard() {
        // Valid Visa card number
        assertTrue(CreditCardValidator.isValidCreditCard("4111111111111111"));

        // Valid MasterCard number
        assertTrue(CreditCardValidator.isValidCreditCard("5111111111111111"));

        // Invalid card number (too short)
        assertFalse(CreditCardValidator.isValidCreditCard("411111111111111"));

        // Invalid card number (too long)
        assertFalse(CreditCardValidator.isValidCreditCard("51111111111111111"));

        // Invalid card number (invalid starting digit)
        assertFalse(CreditCardValidator.isValidCreditCard("6111111111111111"));
    }
}

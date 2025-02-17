package Day05_Regex_JUnit.Regex.AdvancedProblems;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SSNValidatorTest {

    @Test
    public void testValidSSN() {
        // Valid SSNs
        assertTrue(SSNValidator.isValidSSN("123-45-6789"));
        assertTrue(SSNValidator.isValidSSN("987-65-4321"));
    }

    @Test
    public void testInvalidSSN_NoHyphens() {
        // Invalid SSNs without hyphens
        assertFalse(SSNValidator.isValidSSN("123456789"));
        assertFalse(SSNValidator.isValidSSN("987654321"));
    }

    @Test
    public void testInvalidSSN_TooShort() {
        // Invalid SSNs that are too short
        assertFalse(SSNValidator.isValidSSN("123-45-678"));
        assertFalse(SSNValidator.isValidSSN("123-45-67"));
    }

    @Test
    public void testInvalidSSN_TooLong() {
        // Invalid SSNs that are too long
        assertFalse(SSNValidator.isValidSSN("123-45-67890"));
        assertFalse(SSNValidator.isValidSSN("123-456-7890"));
    }

    @Test
    public void testInvalidSSN_ExtraCharacters() {
        // Invalid SSNs with extra characters
        assertFalse(SSNValidator.isValidSSN("123-45-6789!"));
        assertFalse(SSNValidator.isValidSSN("12345-6789"));
    }
}

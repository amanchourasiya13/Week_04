package Day05_Regex_JUnit.JUnit.AdvanceJunit_PracticeProblems;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PasswordValidatorTest {

    // Test valid password
    @Test
    void testValidPassword() {
        assertTrue(PasswordValidator.isValidPassword("Password123"), "Password should be valid.");
    }

    // Test password that is too short
    @Test
    void testPasswordTooShort() {
        assertFalse(PasswordValidator.isValidPassword("Pass1"), "Password should be invalid when it is too short.");
    }

    // Test password with no uppercase letter
    @Test
    void testNoUpperCase() {
        assertFalse(PasswordValidator.isValidPassword("password123"), "Password should be invalid if it has no uppercase letter.");
    }

    // Test password with no digit
    @Test
    void testNoDigit() {
        assertFalse(PasswordValidator.isValidPassword("Password"), "Password should be invalid if it has no digit.");
    }

    // Test password with special characters (valid)
    @Test
    void testValidPasswordWithSpecialChars() {
        assertTrue(PasswordValidator.isValidPassword("P@ssw0rd123"), "Password with special characters should be valid if it meets the requirements.");
    }
}

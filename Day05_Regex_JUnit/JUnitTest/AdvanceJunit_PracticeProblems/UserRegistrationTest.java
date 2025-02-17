package Day05_Regex_JUnit.JUnit.AdvanceJunit_PracticeProblems;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class UserRegistrationTest {

    private final UserRegistration userRegistration = new UserRegistration();

    // Test for valid inputs
    @Test
    public void testRegisterUserValid() {
        assertDoesNotThrow(() -> userRegistration.registerUser("validUser", "user@example.com", "password123"));
    }

    // Test for invalid username (empty)
    @Test
    public void testRegisterUserInvalidUsername() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            userRegistration.registerUser("", "user@example.com", "password123");
        });
        assertEquals("Username cannot be empty", exception.getMessage());
    }

    // Test for invalid email (missing '@')
    @Test
    public void testRegisterUserInvalidEmail() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            userRegistration.registerUser("validUser", "userexample.com", "password123");
        });
        assertEquals("Invalid email format", exception.getMessage());
    }

    // Test for invalid email (missing '.')
    @Test
    public void testRegisterUserInvalidEmailFormat() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            userRegistration.registerUser("validUser", "user@com", "password123");
        });
        assertEquals("Invalid email format", exception.getMessage());
    }

    // Test for invalid password (too short)
    @Test
    public void testRegisterUserInvalidPassword() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            userRegistration.registerUser("validUser", "user@example.com", "pwd");
        });
        assertEquals("Password must be at least 6 characters long", exception.getMessage());
    }

    // Test for invalid password (null)
    @Test
    public void testRegisterUserNullPassword() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            userRegistration.registerUser("validUser", "user@example.com", null);
        });
        assertEquals("Password must be at least 6 characters long", exception.getMessage());
    }
}

package Day05_Regex_JUnit.Regex.BasicRegexProblems;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UsernameValidatorTest {

    @Test
    public void testValidUsername() {
        assertTrue(UsernameValidator.isValidUsername("user_123"));
        assertTrue(UsernameValidator.isValidUsername("valid_username"));
    }

    @Test
    public void testInvalidUsername() {
        assertFalse(UsernameValidator.isValidUsername("123user"));
        assertFalse(UsernameValidator.isValidUsername("us"));
        assertFalse(UsernameValidator.isValidUsername("_invalid"));
        assertFalse(UsernameValidator.isValidUsername("!invalid"));
    }
}

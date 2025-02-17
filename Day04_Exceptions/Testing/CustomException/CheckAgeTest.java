package Day04_Exceptions.CustomException;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CheckAgeTest {

    // Test for valid age (18 or older)
    @Test
    void testValidAge() {
        // Test with age 20, which is valid
        int age = 20;

        // Try calling validateAge and ensuring no exception is thrown
        try {
            CheckAge.validateAge(age);
        } catch (CustomException e) {
            fail("CustomException should not be thrown for age 20");
        }
    }

    // Test for invalid age (less than 18)
    @Test
    void testInvalidAge() {
        // Test with age 15, which should trigger the exception
        int age = 15;

        // Verify that the CustomException is thrown
        CustomException exception = assertThrows(CustomException.class, () -> {
            CheckAge.validateAge(age);
        });

        // Verify the exception message
        assertEquals("Age must be 18 or older", exception.getMessage());
    }
}

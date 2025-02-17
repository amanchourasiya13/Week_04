package Day04_Exceptions.throwVsthrowsException;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ExceptionPropagationTest {

    // Test for valid inputs
    @Test
    void testCalculateInterestValidInput() {
        double amount = 1000.00;
        double rate = 5;
        int years = 3;

        // Calculate interest without expecting an exception
        double expectedInterest = (amount * rate * years) / 100;
        double actualInterest = 0;

        try {
            actualInterest = ExceptionPropagation.calculateInterest(amount, rate, years);
        } catch (IllegalArgumentException e) {
            fail("No exception should be thrown for valid input");
        }

        // Verify that the interest calculation is correct
        assertEquals(expectedInterest, actualInterest, 0.01);
    }

    // Test for invalid input (negative amount)
    @Test
    void testCalculateInterestInvalidAmount() {
        double amount = -1000.00;  // Negative amount
        double rate = 5;
        int years = 3;

        // Verify that the exception is thrown
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            ExceptionPropagation.calculateInterest(amount, rate, years);
        });

        // Verify the exception message
        assertEquals("Invalid Input: Amount and rate must be positive", exception.getMessage());
    }

    // Test for invalid input (negative rate)
    @Test
    void testCalculateInterestInvalidRate() {
        double amount = 1000.00;
        double rate = -5;  // Negative rate
        int years = 3;

        // Verify that the exception is thrown
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            ExceptionPropagation.calculateInterest(amount, rate, years);
        });

        // Verify the exception message
        assertEquals("Invalid Input: Amount and rate must be positive", exception.getMessage());
    }

    // Test for invalid input (both negative amount and rate)
    @Test
    void testCalculateInterestInvalidAmountAndRate() {
        double amount = -1000.00;  // Negative amount
        double rate = -5;  // Negative rate
        int years = 3;

        // Verify that the exception is thrown
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            ExceptionPropagation.calculateInterest(amount, rate, years);
        });

        // Verify the exception message
        assertEquals("Invalid Input: Amount and rate must be positive", exception.getMessage());
    }
}

package Day04_Exceptions.UncheckedException;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class Arithmetic_InputMismatchedExceptionTest {

    // Test for valid input
    @Test
    void testValidInput() {
        // Set the input for valid integers
        String input = "10\n2\n";
        System.setIn(new java.io.ByteArrayInputStream(input.getBytes()));

        // Capture the output of the system
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Run the uncheckException method
        Arithmetic_InputMismatchedException.uncheckException();

        // Verify that the result is correct (division of 10 by 2 = 5)
        String output = outputStream.toString();
        assertTrue(output.contains("Result: 5"));
    }

    // Test for InputMismatchException (non-numeric input)
    @Test
    void testInputMismatchException() {
        // Set the input for non-numeric input (to trigger InputMismatchException)
        String input = "abc\n2\n";  // First input is not a number
        System.setIn(new java.io.ByteArrayInputStream(input.getBytes()));

        // Capture the output of the system
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Run the uncheckException method
        Arithmetic_InputMismatchedException.uncheckException();

        // Verify that the exception message is correct
        String output = outputStream.toString();
        assertTrue(output.contains("Input Mismatch Exception Caught. Please enter only numeric values"));
    }

    // Test for ArithmeticException (division by zero)
    @Test
    void testArithmeticException() {
        // Set the input for division by zero
        String input = "10\n0\n";  // First value is 10, second value is 0 (division by zero)
        System.setIn(new java.io.ByteArrayInputStream(input.getBytes()));

        // Capture the output of the system
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Run the uncheckException method
        Arithmetic_InputMismatchedException.uncheckException();

        // Verify that the exception message is correct
        String output = outputStream.toString();
        assertTrue(output.contains("Arithmetic Exception Caught"));
    }
}

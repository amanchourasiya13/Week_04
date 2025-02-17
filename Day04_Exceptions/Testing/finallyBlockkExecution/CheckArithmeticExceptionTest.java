package Day04_Exceptions.finallyBlockkExecution;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class CheckArithmeticExceptionTest {

    @Test
    void testUncheckExceptionWithValidInput() {
        // Simulate user input for a valid division (e.g., 10 / 2)
        String input = "10\n2\n";  // Input for first value and second value
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // Capture the output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Call the method to test
        CheckArithmeticException.uncheckException();

        // Get the captured output
        String output = outputStream.toString();

        // Verify that the correct result and "Operation Completed" are printed
        assertTrue(output.contains("Result: 5"));
        assertTrue(output.contains("Operation Completed"));
    }

    @Test
    void testUncheckExceptionWithZeroDivision() {
        // Simulate user input for division by zero (e.g., 10 / 0)
        String input = "10\n0\n";  // Input for first value and second value
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // Capture the output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Call the method to test
        CheckArithmeticException.uncheckException();

        // Get the captured output
        String output = outputStream.toString();

        // Verify that the exception message is printed
        assertTrue(output.contains("Arithmetic Exception Caught: / by zero"));
        assertTrue(output.contains("Operation Completed"));
    }
}

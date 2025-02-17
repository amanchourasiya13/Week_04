package Day04_Exceptions.ExceptionPropagationInMethods;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class ArithmeticExceptionTest {

    @Test
    void testExceptionPropagationInMethods() {
        // Capture the output of the main method using System.out redirection
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Call the main method directly to trigger exception propagation
        String[] args = {};  // No arguments needed
        ArithmeticException.main(args);

        // Get the captured output
        String output = outputStream.toString();

        // Verify that the exception was handled in the main method
        assertTrue(output.contains("Handle exception in main"));
        assertTrue(output.contains("/ by zero"));
    }
}

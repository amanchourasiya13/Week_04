package Day05_Regex_JUnit.JUnit.BasicJUnitTest;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
public class CalculatorExceptionTest {

    // Test normal division (e.g., 10 / 2)
    @Test
    public void testDivideNormal() {
        // Capture output using a ByteArrayOutputStream and PrintStream
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        CalculatorException.divide(10, 2);

        String output = outputStream.toString().trim();
        assertEquals("Result: 5", output);
    }

    // Test division by zero, expecting an ArithmeticException
    @Test
    public void testDivideByZero() {
        Exception exception = assertThrows(ArithmeticException.class, () -> {
            CalculatorException.divide(10, 0);
        });

        assertEquals("Cannot divide by zero", exception.getMessage());
    }
}

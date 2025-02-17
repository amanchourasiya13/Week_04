
package Day04_Exceptions.Nestedtry_CatchBlock;
//import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.*;
//import java.io.ByteArrayInputStream;
//import java.io.ByteArrayOutputStream;
//import java.io.PrintStream;
//
//class NestedTryCatchTest {
//
//    @Test
//    void testValidInput() {
//        // Simulate valid input: array size 3, array elements: 5, 2, 5, index: 1, divisor: 2
//        String input = "3\n5\n2\n5\n1\n2\n";  // Corrected input with newline separation
//        System.setIn(new ByteArrayInputStream(input.getBytes()));
//
//        // Capture the output
//        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(outputStream));
//
//        // Call the main method
//        String[] args = {};
//        NestedTryCatch.main(args);
//
//        // Get the captured output
//        String output = outputStream.toString();
//
//        // Verify that the result is correctly printed
//        assertTrue(output.contains("Result: 2"));
//    }
//
//    @Test
//    void testInvalidIndex() {
//        // Simulate input that causes an ArrayIndexOutOfBoundsException
//        String input = "3\n5\n2\n5\n5\n2\n";  // Array size 3, invalid index 5, divisor 2
//        System.setIn(new ByteArrayInputStream(input.getBytes()));
//
//        // Capture the output
//        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(outputStream));
//
//        // Call the main method
//        String[] args = {};
//        NestedTryCatch.main(args);
//
//        // Get the captured output
//        String output = outputStream.toString();
//
//        // Verify that the "Invalid array index!" message is printed
//        assertTrue(output.contains("Invalid array index!"));
//    }
//
//    @Test
//    void testDivisionByZero() {
//        // Simulate input that causes an ArithmeticException (division by zero)
//        String input = "3\n1\n0\n5\n0\n2\n";  // Array size 3, index 1, divisor 0
//        System.setIn(new ByteArrayInputStream(input.getBytes()));
//
//        // Capture the output
//        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(outputStream));
//
//        // Call the main method
//        String[] args = {};
//        NestedTryCatch.main(args);
//
//        // Get the captured output
//        String output = outputStream.toString();
//
//        // Verify that the "Cannot divide by zero!" message is printed
//        assertTrue(output.contains("Cannot divide by zero!"));
//    }
//}
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class NestedTryCatchTest{
    @Test
    void testValidInput() {
        // Simulate valid input: array size 3, array elements: 5, 2, 5, index: 1, divisor: 2
        String input = "3\n5\n2\n5\n1\n2\n";  // Corrected input with newline separation
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // Capture the output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Call the main method
        String[] args = {};
        Day04_Exceptions.Nestedtry_CatchBlock.NestedTryCatch.main(args);

        // Get the captured output
        String output = outputStream.toString();

        // Verify that the result is correctly printed
        assertTrue(output.contains("Result: 1"));  // The result should be 2/2 = 1
    }


    @Test
    void testInvalidIndex() {
        // Simulate input that causes an ArrayIndexOutOfBoundsException
        String input = "3\n5\n2\n5\n10\n2\n";  // Array size 3, invalid index 10, divisor 2
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // Capture the output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Call the main method
        String[] args = {};
        Day04_Exceptions.Nestedtry_CatchBlock.NestedTryCatch.main( args);


        // Get the captured output
        String output = outputStream.toString();

        // Verify that the "Invalid array index!" message is printed
        assertTrue(output.contains("Invalid array index!"));
    }

    @Test
    void testDivisionByZero() {
        // Simulate input that causes an ArithmeticException (division by zero)
        String input = "3\n5\n2\n5\n1\n0\n";  // Array size 3, index 1, divisor 0
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // Capture the output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Call the main method
        String[] args = {};
         Day04_Exceptions.Nestedtry_CatchBlock.NestedTryCatch.main( args);

        // Get the captured output
        String output = outputStream.toString();

        // Verify that the "Cannot divide by zero!" message is printed
        assertTrue(output.contains("Cannot divide by zero!"));
    }
}

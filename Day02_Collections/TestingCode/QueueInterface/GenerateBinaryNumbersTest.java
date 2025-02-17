package Day02_Collections.QueueInterface;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GenerateBinaryNumbersTest {

    // Test case to verify the binary number generation
    @Test
    public void testGenerateBinaryNumbers() {
        // Number of binary numbers to generate
        int N = 5;

        // Expected result for the first 5 binary numbers
        String[] expectedBinaryNumbers = {"1", "10", "11", "100", "101"};

        // Generate the binary numbers
        String[] generatedBinaryNumbers = GenerateBinaryNumbers.generateBinaryNumbers(N);

        // Assert that the generated binary numbers match the expected ones
        assertArrayEquals(expectedBinaryNumbers, generatedBinaryNumbers, "The binary numbers generated are incorrect.");
    }

    // Test case for generating a single binary number
    @Test
    public void testGenerateBinaryNumbersSingle() {
        // Number of binary numbers to generate
        int N = 1;

        // Expected result for a single binary number
        String[] expectedBinaryNumbers = {"1"};

        // Generate the binary numbers
        String[] generatedBinaryNumbers = GenerateBinaryNumbers.generateBinaryNumbers(N);

        // Assert that the generated binary numbers match the expected ones
        assertArrayEquals(expectedBinaryNumbers, generatedBinaryNumbers, "The binary number generated is incorrect.");
    }

    // Test case for generating zero binary numbers
    @Test
    public void testGenerateBinaryNumbersZero() {
        // Number of binary numbers to generate
        int N = 0;

        // Expected result for zero binary numbers
        String[] expectedBinaryNumbers = {};

        // Generate the binary numbers
        String[] generatedBinaryNumbers = GenerateBinaryNumbers.generateBinaryNumbers(N);

        // Assert that the generated binary numbers match the expected ones
        assertArrayEquals(expectedBinaryNumbers, generatedBinaryNumbers, "The result should be an empty array for N = 0.");
    }
}

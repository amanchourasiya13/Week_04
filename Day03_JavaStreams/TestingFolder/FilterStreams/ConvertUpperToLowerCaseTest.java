package Day03_JavaStreams.ProblemStatement.FilterStreams;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.*;
import static org.junit.jupiter.api.Assertions.*;

public class ConvertUpperToLowerCaseTest {

    private static final String INPUT_FILE_PATH = "src/main/java/Day03_JavaStreams/ProblemStatement/FilterStreams/InputFile.txt";
    private static final String OUTPUT_FILE_PATH = "src/main/java/Day03_JavaStreams/ProblemStatement/FilterStreams/OuputFile.txt";

    // Setup: Create input file with uppercase text
    @BeforeEach
    public void setUp() throws IOException {
        File inputFile = new File(INPUT_FILE_PATH);
        if (!inputFile.exists()) {
            inputFile.createNewFile();
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(inputFile))) {
            writer.write("HELLO WORLD");
            writer.newLine();
            writer.write("JAVA STREAMS ARE FUN");
        }
    }

    // Cleanup: Delete the output file after the test
    @AfterEach
    public void tearDown() {
        File outputFile = new File(OUTPUT_FILE_PATH);
        if (outputFile.exists()) {
            outputFile.delete();
        }
    }

    // Test that the conversion from uppercase to lowercase works
    @Test
    public void testConvertUpperToLower() {
        ConvertUpperToLowerCase.convertUpperToLower(INPUT_FILE_PATH, OUTPUT_FILE_PATH);

        // Check that the output file is created
        File outputFile = new File(OUTPUT_FILE_PATH);
        assertTrue(outputFile.exists(), "Output file should be created.");

        // Check the contents of the output file
        try (BufferedReader reader = new BufferedReader(new FileReader(outputFile))) {
            String line1 = reader.readLine();
            String line2 = reader.readLine();

            // Check if the content is in lowercase
            assertEquals("hello world", line1, "The first line should be in lowercase.");
            assertEquals("java streams are fun", line2, "The second line should be in lowercase.");
        } catch (IOException e) {
            fail("IOException while reading the output file: " + e.getMessage());
        }
    }

    // Edge case: Test when the input file is empty
    @Test
    public void testEmptyFile() throws IOException {
        // Create an empty input file for testing
        File emptyInputFile = new File(INPUT_FILE_PATH);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(emptyInputFile))) {
            // Do nothing (empty file)
        }

        // Run the method
        ConvertUpperToLowerCase.convertUpperToLower(INPUT_FILE_PATH, OUTPUT_FILE_PATH);

        // Check that the output file exists
        File outputFile = new File(OUTPUT_FILE_PATH);
        assertTrue(outputFile.exists(), "Output file should be created even if the input file is empty.");

        // Check that the output file is also empty
        try (BufferedReader reader = new BufferedReader(new FileReader(outputFile))) {
            assertNull(reader.readLine(), "The output file should be empty for an empty input file.");
        } catch (IOException e) {
            fail("IOException while reading the output file: " + e.getMessage());
        }
    }

    // Edge case: Test when the input file doesn't exist
    @Test
    public void testFileNotFound() {
        String invalidFilePath = "src/test/resources/nonExistingFile.txt";
        ConvertUpperToLowerCase.convertUpperToLower(invalidFilePath, OUTPUT_FILE_PATH);

        // Check if the output file is NOT created
        File outputFile = new File(OUTPUT_FILE_PATH);
        assertFalse(outputFile.exists(), "Output file should not be created if input file doesn't exist.");
    }
}

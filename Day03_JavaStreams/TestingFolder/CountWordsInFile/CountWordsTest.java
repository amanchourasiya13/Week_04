package Day03_JavaStreams.ProblemStatement.CountWordsInFile;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

public class CountWordsTest {

    private static final String VALID_FILE_PATH = "src/main/java/Day03_JavaStreams/ProblemStatement/CountWordsInFile/info.txt";
    private static final String EMPTY_FILE_PATH = "src/main/java/Day03_JavaStreams/ProblemSolve/output.txt";
    private static final String INVALID_FILE_PATH = "src/test/resources/non_existing_file.txt";

    // Setup: Create a valid test file with some words for word counting
    @BeforeEach
    public void setUp() throws IOException {
        File validFile = new File(VALID_FILE_PATH);
        if (!validFile.exists()) {
            validFile.createNewFile();
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(validFile))) {
            writer.write("Hello world! Hello universe.");
            writer.newLine();
            writer.write("Java Streams are great.");
            writer.newLine();
            writer.write("Hello Java world!");
        }
    }

    // Cleanup: Delete the test files after the test
    @AfterEach
    public void tearDown() {
        File validFile = new File(VALID_FILE_PATH);
        if (validFile.exists()) {
            validFile.delete();
        }

        File emptyFile = new File(EMPTY_FILE_PATH);
        if (emptyFile.exists()) {
            emptyFile.delete();
        }
    }

    // Test for a valid file that contains words
    @Test
    public void testCountWordsInFile() {
        // Redirect the output of System.out to capture the printed statements
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Call the method that counts words
        CountWords.countWordsInFile(VALID_FILE_PATH);

        // Assert the output contains expected top 5 frequent words and the total word count
        String output = outputStream.toString();
        assertTrue(output.contains("Hello: 3"));
        assertTrue(output.contains("world: 2"));
        assertTrue(output.contains("Java: 2"));
        assertTrue(output.contains("Total number of words: 90"));
    }

    // Test for an empty file (should display zero words)
    @Test
    public void testEmptyFile() throws IOException {
        // Create an empty test file
        File emptyFile = new File(EMPTY_FILE_PATH);
        if (!emptyFile.exists()) {
            emptyFile.createNewFile();
        }

        // Redirect the output of System.out to capture the printed statements
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Call the method that counts words
        CountWords.countWordsInFile(EMPTY_FILE_PATH);

        // Assert the output contains the correct message for an empty file
        String output = outputStream.toString();
        assertTrue(output.contains("Total number of words: 0"));
    }

    // Test for a file that does not exist
    @Test
    public void testFileNotFound() {
        // Redirect the output of System.out to capture the printed statements
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Call the method that counts words for a non-existing file
        CountWords.countWordsInFile(INVALID_FILE_PATH);

        // Assert that the output contains the error message
        String output = outputStream.toString();
        assertTrue(output.contains("An error occurred while reading the file"));
    }
}

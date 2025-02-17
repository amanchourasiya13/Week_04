package Day03_JavaStreams.ProblemStatement.BufferedStreams;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;

public class BufferStreamsTest {

    private static final String inputFilePath = "src/test/java/Day03_JavaStreams/ProblemStatement/BufferedStreams/InputFile.txt";
    private static final String outputBufferedFilePath = "src/test/java/Day03_JavaStreams/ProblemStatement/BufferedStreams/OutputBufferedFile.txt";
    private static final String outputUnbufferedFilePath = "src/test/java/Day03_JavaStreams/ProblemStatement/BufferedStreams/OutputUnbufferedFile.txt";

    // Setup method to create the input file with test data
    @BeforeEach
    public void setUp() throws IOException {
        String content = "This is a test file for buffered and unbuffered copy methods.";
        try (FileOutputStream fos = new FileOutputStream(inputFilePath)) {
            fos.write(content.getBytes());
        }
    }

    // Test for the Buffered Example method
    @Test
    public void testBufferedExample() {
        // Call the BufferedExample method to copy the file
        BufferStreams.BufferedExample(inputFilePath, outputBufferedFilePath);

        // Check if the output file is created
        File outputFile = new File(outputBufferedFilePath);
        assertTrue(outputFile.exists(), "Buffered output file should exist.");

        // Read the content of both input and output files and compare
        try {
            byte[] inputFileContent = Files.readAllBytes(new File(inputFilePath).toPath());
            byte[] outputFileContent = Files.readAllBytes(outputFile.toPath());

            assertArrayEquals(inputFileContent, outputFileContent, "The content of the buffered files should be the same.");
        } catch (IOException e) {
            fail("IOException occurred while reading the files: " + e.getMessage());
        }
    }

    // Test for the Unbuffered Example method
    @Test
    public void testInputOutputStreamExample() {
        // Call the InputOutputStreamExample method to copy the file
        BufferStreams.InputOutputStreamExample(inputFilePath, outputUnbufferedFilePath);

        // Check if the output file is created
        File outputFile = new File(outputUnbufferedFilePath);
        assertTrue(outputFile.exists(), "Unbuffered output file should exist.");

        // Read the content of both input and output files and compare
        try {
            byte[] inputFileContent = Files.readAllBytes(new File(inputFilePath).toPath());
            byte[] outputFileContent = Files.readAllBytes(outputFile.toPath());

            assertArrayEquals(inputFileContent, outputFileContent, "The content of the unbuffered files should be the same.");
        } catch (IOException e) {
            fail("IOException occurred while reading the files: " + e.getMessage());
        }
    }

    // Test for performance comparison between buffered and unbuffered copy methods
    @Test
    public void testPerformanceComparison() {
        long start, end;

        // Measure time for the buffered method
        start = System.nanoTime();
        BufferStreams.BufferedExample(inputFilePath, outputBufferedFilePath);
        end = System.nanoTime();
        long timeBuffered = end - start;

        // Measure time for the unbuffered method
        start = System.nanoTime();
        BufferStreams.InputOutputStreamExample(inputFilePath, outputUnbufferedFilePath);
        end = System.nanoTime();
        long timeUnbuffered = end - start;

        // Print out the time taken for both methods
        System.out.println("Time taken by buffered: " + timeBuffered + " ns.");
        System.out.println("Time taken by unbuffered: " + timeUnbuffered + " ns.");

        // Assert that buffered method is faster
        assertTrue(timeBuffered < timeUnbuffered, "Buffered method should be faster than unbuffered.");
    }

    // Cleanup method to delete files after each test
    @AfterEach
    public void tearDown() {
        new File(inputFilePath).delete();
        new File(outputBufferedFilePath).delete();
        new File(outputUnbufferedFilePath).delete();
    }
}

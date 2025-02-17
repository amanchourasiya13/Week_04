package Day03_JavaStreams.ProblemStatement.FileHandling;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;

public class FileINPUT_OUTPUT_StreamTest {

    private static final String inputFilePath = "src/test/java/Day03_JavaStreams/ProblemStatement/FileHandling/InputFile.txt";
    private static final String outputFilePath = "src/test/java/Day03_JavaStreams/ProblemStatement/FileHandling/OutputFile.txt";

    // Setup method to create test input file
    @BeforeEach
    public void setUp() throws IOException {
        String content = "This is a test file.";
        try (FileOutputStream fos = new FileOutputStream(inputFilePath)) {
            fos.write(content.getBytes());
        }
    }

    // Test case to check if the file is copied correctly
    @Test
    public void testInputOutputStreamExample() {
        // Call the method you want to test
        FileINPUT_OUTPUT_Stream.InputOutputStreamExample(inputFilePath, outputFilePath);

        // Check if the output file is created
        File outputFile = new File(outputFilePath);
        assertTrue(outputFile.exists(), "Output file should exist after copy.");

        // Read the content of the output file
        try {
            byte[] inputFileContent = Files.readAllBytes(new File(inputFilePath).toPath());
            byte[] outputFileContent = Files.readAllBytes(outputFile.toPath());

            // Check if both files have the same content
            assertArrayEquals(inputFileContent, outputFileContent, "The content of the files should be the same.");
        } catch (IOException e) {
            fail("IOException occurred while reading the files: " + e.getMessage());
        }
    }

    // Cleanup method to delete files after the test
    @AfterEach
    public void tearDown() {
        new File(inputFilePath).delete();
        new File(outputFilePath).delete();
    }
}

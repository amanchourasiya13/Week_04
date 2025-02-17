package Day05_Regex_JUnit.JUnit.BasicJUnitTest;

import org.junit.jupiter.api.*;
import java.io.*;
import java.nio.file.*;

import static org.junit.jupiter.api.Assertions.*;

public class FileProcessorTest {

    private static final String FILENAME = "testfile.txt";
    private FileProcessor fileProcessor;

    @BeforeEach
    public void setUp() {
        fileProcessor = new FileProcessor();
    }

    @AfterEach
    public void cleanUp() {
        // Delete the test file after each test to ensure no leftover files
        try {
            Files.deleteIfExists(Paths.get(FILENAME));
        } catch (IOException e) {
            System.err.println("Failed to delete test file: " + e.getMessage());
        }
    }

    // Test if content is written correctly
    @Test
    public void testWriteToFile() throws IOException {
        String content = "Hello, World!";
        fileProcessor.writeToFile(FILENAME, content);

        // Check if file exists
        assertTrue(Files.exists(Paths.get(FILENAME)));

        // Read from file and verify content
        String fileContent = fileProcessor.readFromFile(FILENAME);
        assertEquals(content, fileContent);
    }

    // Test if file is correctly read
    @Test
    public void testReadFromFile() throws IOException {
        String content = "This is a sample content!";
        fileProcessor.writeToFile(FILENAME, content);

        // Read the content and verify it
        String fileContent = fileProcessor.readFromFile(FILENAME);
        assertEquals(content, fileContent);
    }

    // Test IOException when file doesn't exist
    @Test
    public void testFileNotFound() {
        assertThrows(IOException.class, () -> {
            fileProcessor.readFromFile("nonexistentfile.txt");
        });
    }
}

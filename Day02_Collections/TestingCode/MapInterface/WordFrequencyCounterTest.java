
package Day02_Collections.MapInterface;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.*;
import java.util.Map;

public class WordFrequencyCounterTest {

    @Test
    public void testCountWordFrequency() throws IOException {
        // Setup a temporary file for testing
        String testContent = "Hello world, hello Java!";
        File tempFile = File.createTempFile("testFile", ".txt");
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
        writer.write(testContent);
        writer.close();

        // Act: Call the method to count word frequency
        Map<String, Integer> wordFrequency = WordFrequencyCounter.countWordFrequency(tempFile.getAbsolutePath());

        // Assert: Verify the expected word frequencies
        assertNotNull(wordFrequency);
        assertEquals(2, wordFrequency.get("hello"));
        assertEquals(1, wordFrequency.get("world"));
        assertEquals(1, wordFrequency.get("java"));

        // Cleanup: Delete the temporary file after test
        tempFile.delete();
    }

    @Test
    public void testEmptyFile() throws IOException {
        // Setup an empty temporary file for testing
        File tempFile = File.createTempFile("emptyFile", ".txt");
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
        writer.close(); // No content written, empty file

        // Act: Call the method to count word frequency
        Map<String, Integer> wordFrequency = WordFrequencyCounter.countWordFrequency(tempFile.getAbsolutePath());

        // Assert: Verify the word frequency is empty
        assertNotNull(wordFrequency);
        assertTrue(wordFrequency.isEmpty());

        // Cleanup: Delete the temporary file after test
        tempFile.delete();
    }
}


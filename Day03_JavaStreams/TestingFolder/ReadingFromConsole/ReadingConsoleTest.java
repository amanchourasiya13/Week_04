package Day03_JavaStreams.ProblemStatement.ReadingFromConsole;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

public class ReadingConsoleTest {

    private static final String TEST_FILE_PATH = "src/test/java/Day03_JavaStreams/ProblemStatement/ReadingFromConsole/TestData.txt";
    private ByteArrayInputStream inputStream;
    private PrintStream originalSystemIn;

    // Setup: redirect system input to simulate user input
    @BeforeEach
    public void setUp() {
        String simulatedUserInput = "John Doe\n25\nJava\n"; // Simulating the user input for name, age, and fav language.
        inputStream = new ByteArrayInputStream(simulatedUserInput.getBytes());
       InputStreamReader originalSystemIn = new InputStreamReader(System.in); // Save the original System.in
        System.setIn(inputStream); // Redirect System.in to simulate input
    }

    // Test the method for writing data to a file
    @Test
    public void testReadingDataInput() throws IOException {
        // Call the method to test
        ReadingConsole.ReadingDataInput(TEST_FILE_PATH);

        // Check if the file has been created and contains the expected data
        File testFile = new File(TEST_FILE_PATH);
        assertTrue(testFile.exists(), "The file should be created.");

        // Read the content from the file
        try (BufferedReader reader = new BufferedReader(new FileReader(testFile))) {
            String line1 = reader.readLine();
            String line2 = reader.readLine();
            String line3 = reader.readLine();
            String line4 = reader.readLine();

            // Validate the content of the file
            assertEquals("Name: John Doe", line1, "The name should be saved in the file.");
            assertEquals("Age: 25", line2, "The age should be saved in the file.");
            assertEquals("Favorite Programming Language: Java", line3, "The favorite language should be saved in the file.");
            assertEquals("-------------------------------", line4, "Separator line should be in the file.");
        }
    }

    // Cleanup: Restore original System.in
    @AfterEach
    public void tearDown() {
         FileInputStream originalSystemIn; // Restore the original System.in
        new File(TEST_FILE_PATH).delete(); // Delete the test file
    }
}

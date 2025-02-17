package Day03_JavaStreams.ProblemStatement.ReadLargeFile;

import org.junit.jupiter.api.Test;
import java.io.*;
import static org.junit.jupiter.api.Assertions.*;

public class ReadingLargeFileTest {

    @Test
    public void testReadFileAndPrintErrors() {
        // Create a temporary file with some sample content
        String testFilePath = "";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(testFilePath))) {
            writer.write("This is a test line with error\n");
            writer.write("This line doesn't have it\n");
            writer.write("Another line with an ERROR in it\n");
            writer.write("Some more content\n");
        } catch(FileNotFoundException e){
            System.out.println("File not found:- "+e.getMessage() );
        }catch (IOException e) {
            e.printStackTrace();
        }

        // Use a ByteArrayOutputStream to capture System.out
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);

        // Redirect System.out to the output stream
        System.setOut(printStream);

        // Call the method to process the file
        ReadingLargeFile.readFileAndPrintErrors(testFilePath);

        // Capture the output printed to System.out
        String output = outputStream.toString();

        // Assert that the output contains the lines with the word "error"
        assertTrue(output.contains("This is a test line with error"));
        assertTrue(output.contains("Another line with an ERROR in it"));

        // Clean up: Delete the test file after the test is done
        File testFile = new File(testFilePath);
        if (testFile.exists()) {
            testFile.delete();
        }
    }

    @Test
    public void testFileNotFound() {
        // Given an invalid file path
        String invalidFilePath = "src/main/java/Day03_JavaStreams/ProblemStatement/ReadLargeFile/Input500MB.txt";

        // Capture the output when the file is not found
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        // Call the method and assert that the exception message is printed
        ReadingLargeFile.readFileAndPrintErrors(invalidFilePath);

        // Check that the output contains "File not Found"
        String output = outputStream.toString();
        assertTrue(output.contains("File not Found"));
    }

    @Test
    public void testReadFileWithNoErrors() {
        // Create a file with no lines containing "error"
        String testFilePath = "src/main/java/Day03_JavaStreams/ProblemStatement/ReadLargeFile/Input500MB.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(testFilePath))) {
            writer.write("This is a line without error\n");
            writer.write("Another line with no error\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Use a ByteArrayOutputStream to capture System.out
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        // Call the method to process the file
        ReadingLargeFile.readFileAndPrintErrors(testFilePath);

        // Capture the output printed to System.out
        String output = outputStream.toString();

        // Assert that no lines with "error" are printed
        assertFalse(output.contains("error"));

        // Clean up: Delete the test file after the test is done
        File testFile = new File(testFilePath);
        if (testFile.exists()) {
            testFile.delete();
        }
    }
}

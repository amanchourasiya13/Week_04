package Day05_Regex_JUnit.JUnit.BasicJUnitTest;

import java.io.*;
import java.nio.file.*;

public class FileProcessor {

    // Method to write content to a file
    public void writeToFile(String filename, String content) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(content);
        }
    }

    // Method to read content from a file
    public String readFromFile(String filename) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filename)));
    }

    // Main method to test file writing and reading
    public static void main(String[] args) {
        FileProcessor fileProcessor = new FileProcessor();
        String filename = "testfile.txt";
        String content = "This is a test file.";

        try {
            // Write to file
            fileProcessor.writeToFile(filename, content);
            System.out.println("Content written to file: " + filename);

            // Read from file
            String fileContent = fileProcessor.readFromFile(filename);
            System.out.println("Content read from file: " + fileContent);

        } catch (IOException e) {
            System.err.println("Error occurred: " + e.getMessage());
        }
    }
}

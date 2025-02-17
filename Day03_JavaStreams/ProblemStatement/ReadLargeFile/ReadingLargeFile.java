package Day03_JavaStreams.ProblemStatement.ReadLargeFile;

import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;

public class ReadingLargeFile {
    public static void main(String[] args) {
        String filePath = "src/main/java/Day03_JavaStreams/ProblemStatement/ReadLargeFile/Input500MB.txt"; // Path to the large file

        // Call the method to process the file
        readFileAndPrintErrors(filePath);
    }

    public static void readFileAndPrintErrors(String filePath) {
        // Using BufferedReader to read the file line by line
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Convert the line to lowercase for case-insensitive comparison
                if (line.toLowerCase().contains("error")) {
                    System.out.println(line); // Print the line if it contains the word "error"
                }
            }
        }catch(FileNotFoundException e){
            System.out.println("File not Found:- "+e.getMessage());
        } catch(IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

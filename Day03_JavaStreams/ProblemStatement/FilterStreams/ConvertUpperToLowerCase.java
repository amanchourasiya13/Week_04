package Day03_JavaStreams.ProblemStatement.FilterStreams;

import java.io.*;

public class ConvertUpperToLowerCase {
    public static void convertUpperToLower(String inputFilePath,String outputFilePath){
        // Convert uppercase to lowercase and write to a new file
        try (
                // Step 1: Create BufferedReader to read the input file
                BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
                // Step 2: Create BufferedWriter to write to the output file
                BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Step 3: Convert the line to lowercase
                String lowerCaseLine = line.toLowerCase();
                // Step 4: Write the modified line to the output file
                writer.write(lowerCaseLine);
                writer.newLine(); // Add a new line after each line of text
            }

            System.out.println("File has been processed and saved to: " + outputFilePath);

            reader.close();
            writer.close();
        } catch(FileNotFoundException e){
            System.out.println("File Not Found.--"+e.getMessage());
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {

        String inputFilePath = "src/main/java/Day03_JavaStreams/ProblemStatement/FilterStreams/InputFile.txt";   // Input file path
        String outputFilePath = "src/main/java/Day03_JavaStreams/ProblemStatement/FilterStreams/OutputFile.txt"; // Output file path

         convertUpperToLower(inputFilePath,outputFilePath);
    }
}

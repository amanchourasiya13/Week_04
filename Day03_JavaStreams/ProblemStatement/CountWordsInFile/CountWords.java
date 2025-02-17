package Day03_JavaStreams.ProblemStatement.CountWordsInFile;

import java.io.IOException;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class CountWords {
    public static void main(String[] args) {
        String filePath = "src/main/java/Day03_JavaStreams/ProblemStatement/CountWordsInFile/info.txt";  // Path to the input text file

        // Call the method to process the file
        countWordsInFile(filePath);
    }

    public static void countWordsInFile(String filePath) {
        // HashMap to store word counts
        HashMap<String, Integer> wordCountMap = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            // Read file line by line
            while ((line = reader.readLine()) != null) {
                // Split the line into words based on non-word characters (whitespace, punctuation)
                String[] words = line.split("\\W+");

                // Iterate over each word and count its occurrence
                for (String word : words) {
                    if (word.length() > 0) {
                        word = word.toLowerCase();  // Convert word to lowercase for case-insensitive comparison
                        wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
                    }
                }
            }

            // Sort the map by frequency (descending order)
            List<Map.Entry<String, Integer>> sortedEntries = new ArrayList<>(wordCountMap.entrySet());
            sortedEntries.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));

            // Display the top 5 most frequent words
            System.out.println("Top 5 most frequent words:");
            int count = 0;
            for (Map.Entry<String, Integer> entry : sortedEntries) {
                if (count >= 5) break;  // Stop after top 5
                System.out.println(entry.getKey() + ": " + entry.getValue());
                count++;
            }

            // Display the total number of words
            int totalWords = wordCountMap.values().stream().mapToInt(Integer::intValue).sum();
            System.out.println("\nTotal number of words: " + totalWords);

        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
    }
}

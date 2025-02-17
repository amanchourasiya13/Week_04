package Day02_Collections.MapInterface;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;

public class WordFrequencyCounter {

    public static void main(String[] args) {
        // Path to the text file
        String filePath = "src/main/java/Day02_Collections/MapInterface/input.txt";
        Map<String, Integer> wordFrequency = countWordFrequency(filePath);

        // Print the word frequency map
        System.out.println(wordFrequency);
    }

    public static Map<String, Integer> countWordFrequency(String filePath) {
        Map<String, Integer> frequencyMap = new HashMap<>();
        BufferedReader reader = null;

        try {
            // Open the file for reading
            reader = new BufferedReader(new FileReader(filePath));
            String line;

            // Read each line of the file
            while ((line = reader.readLine()) != null) {
                // Remove punctuation and convert to lowercase
                line = line.replaceAll("[^a-zA-Z0-9 ]", "").toLowerCase();

                // Split the line into words
                String[] words = line.split("\\s+");

                // Update the frequency of each word
                for (String word : words) {
                    if (!word.isEmpty()) {
                        frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return frequencyMap;
    }
}


package Day02_Collections.QueueInterface;

import java.util.LinkedList;
import java.util.Queue;

public class GenerateBinaryNumbers {

    // Method to generate the first N binary numbers
    public static String[] generateBinaryNumbers(int N) {
        // Initialize a queue
        Queue<String> queue = new LinkedList<>();

        // Add the first binary number "1" to the queue
        queue.add("1");

        // Result array to store binary numbers
        String[] result = new String[N];

        for (int i = 0; i < N; i++) {
            // Dequeue the front element
            String currentBinary = queue.remove();

            // Add the current binary number to the result array
            result[i] = currentBinary;

            // Generate the next binary numbers by appending "0" and "1"
            queue.add(currentBinary + "0");
            queue.add(currentBinary + "1");
        }

        return result;
    }

    public static void main(String[] args) {
        // Number of binary numbers to generate
        int N = 5;

        // Generate the binary numbers
        String[] binaryNumbers = generateBinaryNumbers(N);

        // Output the generated binary numbers
        for (String binary : binaryNumbers) {
            System.out.println(binary);
        }
    }
}

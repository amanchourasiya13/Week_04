package Day03_JavaStreams.ProblemStatement.PipedStreams;

import java.io.PipedInputStream;
import java.io.IOException;
public class ReaderThread extends Thread {
    private PipedInputStream pipedInputStream;

    public ReaderThread(PipedInputStream pipedInputStream) {
        this.pipedInputStream = pipedInputStream;
    }

    @Override
    public void run() {
        try {
            int data;
            StringBuilder receivedData = new StringBuilder();
            while ((data = pipedInputStream.read()) != -1) {
                if (data == '\n') { // When a newline is encountered, print the received data
                    System.out.println("Received: " + receivedData.toString());
                    receivedData.setLength(0);  // Reset the StringBuilder for the next line
                } else {
                    receivedData.append((char) data);
                }
            }
        } catch (IOException e) {
            System.out.println("Error in ReaderThread: " + e.getMessage());
        }
    }
}
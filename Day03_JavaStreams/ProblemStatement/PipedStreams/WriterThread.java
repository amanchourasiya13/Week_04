package Day03_JavaStreams.ProblemStatement.PipedStreams;

import java.io.IOException;
import java.io.PipedOutputStream;

public class WriterThread extends Thread {
    private PipedOutputStream pipedOutputStream;

    public WriterThread(PipedOutputStream pipedOutputStream) {
        this.pipedOutputStream = pipedOutputStream;
    }

    @Override
    public void run() {
        try {
            // Simulate writing data to the pipe
            String[] dataToSend = {"Hello", "from", "WriterThread", "!", "This", "is", "piped", "communication."};
            for (String data : dataToSend) {
                pipedOutputStream.write(data.getBytes());
                pipedOutputStream.write('\n'); // Write a newline after each string
                Thread.sleep(500); // Simulate delay
            }
            pipedOutputStream.close();  // Close the output stream when done
        } catch (IOException | InterruptedException e) {
            System.out.println("Error in WriterThread: " + e.getMessage());
        }
    }
}
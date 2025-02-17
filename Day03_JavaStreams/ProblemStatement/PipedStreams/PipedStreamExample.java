package Day03_JavaStreams.ProblemStatement.PipedStreams;

import java.io.IOException;
import java.io.PipedOutputStream;
import java.io.PipedInputStream;
public class PipedStreamExample {
    public static void main(String[] args) {
        // Create Piped Streams for inter-thread communication
        PipedOutputStream pipedOutputStream = new PipedOutputStream();
        PipedInputStream pipedInputStream = new PipedInputStream();

        try {
            // Connect the PipedOutputStream to the PipedInputStream
            pipedInputStream.connect(pipedOutputStream);

            // Create and start WriterThread and ReaderThread
            Thread writerThread = new WriterThread(pipedOutputStream);
            Thread readerThread = new ReaderThread(pipedInputStream);

            writerThread.start();
            readerThread.start();

            // Wait for both threads to finish
            writerThread.join();
            readerThread.join();
        } catch (IOException | InterruptedException e) {
            System.out.println("Error in main thread: " + e.getMessage());
        }
    }
}
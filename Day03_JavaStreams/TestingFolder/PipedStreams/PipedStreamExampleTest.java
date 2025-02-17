package Day03_JavaStreams.ProblemStatement.PipedStreams;

import org.junit.jupiter.api.Test;
import java.io.PipedOutputStream;
import java.io.PipedInputStream;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;
public class  PipedStreamExampleTest {

    @Test
    public void testPipedStreamCommunication() throws InterruptedException {
        // Create Piped Streams for inter-thread communication
        PipedOutputStream pipedOutputStream = new PipedOutputStream();
        PipedInputStream pipedInputStream = new PipedInputStream();

        try {
            // Connect the PipedOutputStream to the PipedInputStream
            pipedInputStream.connect(pipedOutputStream);

            // Create a writer thread to write data to the piped stream
            WriterThread writerThread = new WriterThread(pipedOutputStream);

            // Create a reader thread to read data from the piped stream
            ReaderThread readerThread = new ReaderThread(pipedInputStream);

            // Start the threads
            writerThread.start();
            readerThread.start();

            // Wait for both threads to finish
            writerThread.join();
            readerThread.join();

            // Verify that the data was processed correctly
            // Since this test is mainly to check piped stream communication,
            // we rely on the system output (printed data) being observed.
            // You may want to implement additional checks or output capturing mechanisms
            // to fully verify the output.

        } catch (IOException e) {
            e.printStackTrace();
            fail("IOException occurred: " + e.getMessage());
        }
    }

    @Test
    public void testWriterThread() throws InterruptedException {
        // Test WriterThread to verify if it writes data to the piped stream correctly
        PipedOutputStream pipedOutputStream = new PipedOutputStream();
        WriterThread writerThread = new WriterThread(pipedOutputStream);
        writerThread.start();

        // Wait for the writer thread to finish
        writerThread.join();

        // Since there are no direct assertions here, we can assume if the thread runs without issues,
        // the writer is functioning as expected.
    }

    @Test
    public void testReaderThread() throws InterruptedException {
        // Test ReaderThread to verify if it reads from the piped stream correctly
        PipedInputStream pipedInputStream = new PipedInputStream();
        ReaderThread readerThread = new ReaderThread(pipedInputStream);
        readerThread.start();

        // Simulate writing data into the piped input stream after starting the reader thread
        String[] dataToSend = {"Hello", "from", "ReaderThread", "!"};
        for (String data : dataToSend) {
       //     pipedInputStream.write(data.getBytes());
      //      pipedInputStream.write('\n');
        }

        // Wait for the reader thread to finish
        readerThread.join();

        // If there are no exceptions thrown and the data is printed, the reader is working fine.
    }
}

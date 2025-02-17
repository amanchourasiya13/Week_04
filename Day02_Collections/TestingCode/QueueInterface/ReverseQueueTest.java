package Day02_Collections.QueueInterface;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;

public class ReverseQueueTest {

    // Test case to verify if the queue is reversed correctly
    @Test
    public void testReverseQueue() {
        // Create and initialize the queue
        Queue<Integer> queue = new LinkedList<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);

        // Reverse the queue
        ReverseQueue.reverseQueue(queue);

        // Verify the reversed queue
        Queue<Integer> expectedQueue = new LinkedList<>();
        expectedQueue.add(30);
        expectedQueue.add(20);
        expectedQueue.add(10);

        // Assert if the queue is reversed correctly
        assertEquals(expectedQueue, queue, "The queue should be reversed.");
    }

    // Test case when the queue is empty
    @Test
    public void testReverseQueueEmpty() {
        // Create an empty queue
        Queue<Integer> queue = new LinkedList<>();

        // Reverse the empty queue
        ReverseQueue.reverseQueue(queue);

        // Assert that the queue remains empty
        assertTrue(queue.isEmpty(), "The queue should remain empty after reversal.");
    }

    // Test case with a single element in the queue
    @Test
    public void testReverseQueueSingleElement() {
        // Create a queue with a single element
        Queue<Integer> queue = new LinkedList<>();
        queue.add(10);

        // Reverse the queue
        ReverseQueue.reverseQueue(queue);

        // Assert that the queue still contains the same single element
        Queue<Integer> expectedQueue = new LinkedList<>();
        expectedQueue.add(10);
        assertEquals(expectedQueue, queue, "The queue should remain the same when there is only one element.");
    }
}

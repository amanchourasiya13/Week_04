package Day02_Collections.QueueInterface;

import java.util.LinkedList;
import java.util.Queue;

public class ReverseQueue {

    public static <T> void reverseQueue(Queue<T> queue) {
            //public static void reverse(Queue<Integer> queue){

        // Base case: If the queue is empty, return
        if (queue.isEmpty()) {
            return;
        }

        // Remove the front element                  //int front=queue.remove();
        T front = queue.remove();

        // Recursively reverse the rest of the queue
        reverseQueue(queue);

        // Add the removed element back to the queue (this will be added at the end)
        queue.add(front);
    }

    public static void main(String[] args) {
        // Create a queue and add elements
        Queue<Integer> queue = new LinkedList<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);

        System.out.println("Original Queue: " + queue);

        // Reverse the queue
        reverseQueue(queue);

        // Print the reversed queue
        System.out.println("Reversed Queue: " + queue);
    }
}


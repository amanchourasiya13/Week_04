package Day02_Collections.QueueInterface;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueues {

    // Two queues to simulate stack
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    // Constructor to initialize the two queues
    public StackUsingQueues() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    // Push operation
    public void push(int x) {
        queue1.add(x); // Add element to the main queue
    }

    // Pop operation
    public int pop() {
        if (queue1.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }

        // Move all elements except the last one to queue2
        while (queue1.size() > 1) {
            queue2.add(queue1.remove());
        }

        // The last element in queue1 is the one to pop
        int poppedElement = queue1.remove();

        // Swap the queues
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;

        return poppedElement;
    }

    // Top operation
    public int top() {
        if (queue1.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }

        // Move all elements except the last one to queue2
        while (queue1.size() > 1) {
            queue2.add(queue1.remove());
        }

        // The last element in queue1 is the top element
        int topElement = queue1.peek();

        // Move the top element to queue2
        queue2.add(queue1.remove());

        // Swap the queues
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;

        return topElement;
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return queue1.isEmpty();
    }

    public static void main(String[] args) {
        StackUsingQueues stack = new StackUsingQueues();

        // Push elements onto the stack
        stack.push(1);
        stack.push(2);
        stack.push(3);

        // Perform pop operation
        System.out.println("Pop: " + stack.pop());  // Output: 3

        // Perform top operation
        System.out.println("Top: " + stack.top());  // Output: 2

        // Perform pop operation again
        System.out.println("Pop: " + stack.pop());  // Output: 2

        // Check if the stack is empty
        System.out.println("Is Empty: " + stack.isEmpty());  // Output: false
    }
}

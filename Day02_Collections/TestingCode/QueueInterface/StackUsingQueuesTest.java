package Day02_Collections.QueueInterface;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StackUsingQueuesTest {

    @Test
    public void testPushAndPop() {
        // Create a new stack
        StackUsingQueues stack = new StackUsingQueues();

        // Push elements onto the stack
        stack.push(1);
        stack.push(2);
        stack.push(3);

        // Pop the top element and assert it's correct
        assertEquals(3, stack.pop(), "Popped element should be 3");

        // Pop the next element and assert it's correct
        assertEquals(2, stack.pop(), "Popped element should be 2");

        // Ensure there's still an element left in the stack
        assertFalse(stack.isEmpty(), "Stack should not be empty.");

        // Pop the last element and assert it's correct
        assertEquals(1, stack.pop(), "Popped element should be 1");

        // Ensure the stack is now empty
        assertTrue(stack.isEmpty(), "Stack should be empty after all elements are popped.");
    }

    @Test
    public void testTop() {
        // Create a new stack
        StackUsingQueues stack = new StackUsingQueues();

        // Push elements onto the stack
        stack.push(10);
        stack.push(20);
        stack.push(30);

        // Test the top element without popping
        assertEquals(30, stack.top(), "Top element should be 30");

        // Pop the top element to verify
        stack.pop();

        // After popping, the new top element should be 20
        assertEquals(20, stack.top(), "Top element should be 20");

        // Pop the next element to verify
        stack.pop();

        // After popping again, the top element should be 10
        assertEquals(10, stack.top(), "Top element should be 10");
    }

    @Test
    public void testIsEmpty() {
        // Create a new stack
        StackUsingQueues stack = new StackUsingQueues();

        // Test if the stack is initially empty
        assertTrue(stack.isEmpty(), "Stack should be empty initially.");

        // Push an element onto the stack
        stack.push(1);

        // Test if the stack is empty after pushing one element
        assertFalse(stack.isEmpty(), "Stack should not be empty after pushing an element.");

        // Pop the element to make the stack empty again
        stack.pop();

        // Test if the stack is empty after popping the last element
        assertTrue(stack.isEmpty(), "Stack should be empty after popping the last element.");
    }

    @Test
    public void testPopOnEmptyStack() {
        // Create a new stack
        StackUsingQueues stack = new StackUsingQueues();

        // Attempt to pop from an empty stack and expect an exception
        assertThrows(IllegalStateException.class, stack::pop, "Popping from an empty stack should throw IllegalStateException.");
    }

    @Test
    public void testTopOnEmptyStack() {
        // Create a new stack
        StackUsingQueues stack = new StackUsingQueues();

        // Attempt to get the top element from an empty stack and expect an exception
        assertThrows(IllegalStateException.class, stack::top, "Getting top from an empty stack should throw IllegalStateException.");
    }
}

package Day02_Collections.QueueInterface;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CircularBufferTest {

    private CircularBuffer buffer;

    @BeforeEach
    public void setUp() {
        // Initialize the buffer before each test
        buffer = new CircularBuffer(3);
    }

    @Test
    public void testInsertAndBufferState() {
        // Insert elements into the buffer
        buffer.insert(1);
        buffer.insert(2);
        buffer.insert(3);

        // The buffer should contain [1, 2, 3]
        assertFalse(buffer.isEmpty(), "Buffer should not be empty after inserting elements.");
        assertEquals(3, buffer.getSize(), "Buffer size should be 3.");

        // Insert more elements and verify the overwriting behavior (circular buffer)
        buffer.insert(4); // Overwrite 1
        assertTrue(buffer.isFull(), "Buffer should be full after 4 is inserted.");
        assertEquals(3, buffer.getSize(), "Buffer size should still be 3.");
    }

    @Test
    public void testInsertAndOverwrite() {
        // Insert elements into the buffer
        buffer.insert(1);
        buffer.insert(2);
        buffer.insert(3);

        // Insert another element, which should overwrite the first one (1)
        buffer.insert(4);
        assertTrue(buffer.isFull(), "Buffer should be full after inserting 4.");
        buffer.printBuffer();  // Expected: Buffer: [2, 3, 4]

        // The buffer should contain [2, 3, 4]
        buffer.insert(5); // Overwrite 2
        buffer.printBuffer();  // Expected: Buffer: [3, 4, 5]

        // After inserting 5, the buffer should contain [3, 4, 5]
    }

    @Test
    public void testIsEmpty() {
        assertTrue(buffer.isEmpty(), "Buffer should be empty initially.");

        // Insert elements into the buffer
        buffer.insert(1);
        assertFalse(buffer.isEmpty(), "Buffer should not be empty after insertion.");
    }

    @Test
    public void testIsFull() {
        assertFalse(buffer.isFull(), "Buffer should not be full initially.");

        // Insert elements to fill the buffer
        buffer.insert(1);
        buffer.insert(2);
        buffer.insert(3);

        assertTrue(buffer.isFull(), "Buffer should be full after 3 elements are inserted.");
    }

    @Test
    public void testBufferStateAfterOverflow() {
        // Insert elements to fill the buffer
        buffer.insert(1);
        buffer.insert(2);
        buffer.insert(3);

        // The buffer should be full
        assertTrue(buffer.isFull(), "Buffer should be full after 3 insertions.");

        // Insert more elements, which should overwrite the oldest elements
        buffer.insert(4);  // Overwrite 1
        buffer.insert(5);  // Overwrite 2
        buffer.printBuffer();  // Expected: Buffer: [4, 5, 3]

        // The buffer should now contain [4, 5, 3]
    }
}

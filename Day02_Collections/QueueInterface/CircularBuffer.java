package Day02_Collections.QueueInterface;

public class CircularBuffer {
    private int[] buffer;
    private int head;
    private int tail;
    private int size;
    private boolean isFull;

    // Constructor to initialize the buffer
    public CircularBuffer(int capacity) {
        buffer = new int[capacity];
        head = 0;
        tail = 0;
        size = 0;
        isFull = false;
    }


    // Insert element into the buffer
    public void insert(int value) {
        if (isFull) {
            // If buffer is full, overwrite the oldest element
            head = (head + 1) % buffer.length;
        }

        // Insert the new element at the tail position
        buffer[tail] = value;

        // Move the tail pointer to the next position
        tail = (tail + 1) % buffer.length;

        // If the buffer is full, mark it as full
        if (tail == head) {
            isFull = true;
        }

        // If the buffer isn't full, increase the size
        if (size < buffer.length) {
            size++;
        }
    }

    // Print the current buffer state
    public void printBuffer() {
        System.out.print("Buffer: [");
        for (int i = 0; i < size; i++) {
            System.out.print(buffer[(head + i) % buffer.length]);
            if (i < size - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    // Check if the buffer is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Check if the buffer is full
    public boolean isFull() {
        return size == buffer.length;
    }
public int getSize(){
        return size;
}
    public static void main(String[] args) {
        CircularBuffer buffer = new CircularBuffer(3);

        // Insert elements into the buffer
        buffer.insert(1);
        buffer.insert(2);
        buffer.insert(3);
        buffer.printBuffer(); // Output: Buffer: [1, 2, 3]

        // Insert more elements (will overwrite the oldest elements)
        buffer.insert(4);
        buffer.printBuffer(); // Output: Buffer: [2, 3, 4]

        // Insert another element
        buffer.insert(5);
        buffer.printBuffer(); // Output: Buffer: [3, 4, 5]
    }
}

package Day04_Exceptions.MultipleCatchBlocks;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ArrayOutOfBound_NullPointerExceptionTest {

    @Test
    void testArrayExceptionWithValidIndex() {
        int[] arr = {10, 20, 30, 40, 50};  // Array with valid values
        ArrayOutOfBound_NullPointerException.arrayException(arr, 2);
        // This will print the value at index 2, which should be 30
    }

    @Test
    void testArrayExceptionWithNullArray() {
        int[] arr = null;  // Null array
        ArrayOutOfBound_NullPointerException.arrayException(arr, 2);
        // This should print "Array is not initialized!" and return without trying to access the array
    }

    @Test
    void testArrayExceptionWithInvalidIndex() {
        int[] arr = {10, 20, 30};  // Array with 3 elements
        ArrayOutOfBound_NullPointerException.arrayException(arr, 5);
        // This will trigger an ArrayIndexOutOfBoundsException and print "Invalid index!"
    }

    @Test
    void testArrayExceptionWithZeroSizedArray() {
        int[] arr = {};  // Empty array (size 0)
        ArrayOutOfBound_NullPointerException.arrayException(arr, 0);
        // This should work without any exception, but it will return the default value for an empty array
    }
}

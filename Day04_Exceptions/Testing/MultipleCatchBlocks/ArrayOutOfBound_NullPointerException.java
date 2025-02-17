
package Day04_Exceptions.MultipleCatchBlocks;

import java.util.Scanner;

public class ArrayOutOfBound_NullPointerException {
    public static void arrayException(int[] arr, int index) {
        try {
            // Check if the array is null before trying to access it
            if (arr == null) {
                System.out.println("Array is not initialized!");
                return;  // Exit the method if the array is null
            }

            // Try to retrieve the value from the array at the specified index
            int value = arr[index];
            System.out.println("Value at index " + index + " : " + value);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index!");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Array size.");
        int n = sc.nextInt();

        // If the user inputs 0 or a negative number, we'll assume the array should be null
        int[] arr = (n > 0) ? new int[n] : null;
        // Initialize the array if it's not null
        if (arr != null) {
            System.out.println("Enter array values: ");
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
        }

        // Prompt for an index to retrieve
        System.out.println("Enter index: ");
        int index = sc.nextInt();

        // Handle array exceptions
        arrayException(arr, index);
    }
}

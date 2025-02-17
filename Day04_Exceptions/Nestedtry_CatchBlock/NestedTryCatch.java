package Day04_Exceptions.Nestedtry_CatchBlock;

import java.util.Scanner;

public class NestedTryCatch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking input for the array and divisor
        System.out.println("Enter the size of the array: ");
        int size = scanner.nextInt();
        int[] arr = new int[size];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println("Enter the index to access: ");
        int index = scanner.nextInt();

        System.out.println("Enter the divisor: ");
        int divisor = scanner.nextInt();

        try {
            // Trying to access the element at the specified index
            try {
                int element = arr[index]; // This might throw ArrayIndexOutOfBoundsException
                // Trying to divide the element by the divisor
                try {
                    int result = element / divisor; // This might throw ArithmeticException
                    System.out.println("Result: " + result);
                } catch (ArithmeticException e) {
                    System.out.println("Cannot divide by zero!");  // Handle division by zero
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Invalid array index!");  // Handle invalid array index
            }
        } finally {
            scanner.close();
        }
    }
}

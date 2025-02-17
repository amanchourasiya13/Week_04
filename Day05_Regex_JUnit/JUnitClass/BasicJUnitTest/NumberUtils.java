package Day05_Regex_JUnit.JUnit.BasicJUnitTest;


public class NumberUtils {

    // Method to check if a number is even
    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    // Main method for manual testing of isEven
    public static void main(String[] args) {
        // Test cases for even and odd numbers
        int[] testNumbers = {2, 4, 6, 7, 9};

        for (int number : testNumbers) {
            boolean result = isEven(number);
            System.out.println("Is " + number + " even? " + result);
        }
    }
}

package Day05_Regex_JUnit.JUnit.BasicJUnitTest;

public class CalculatorException {

    // Method to divide two numbers, throws ArithmeticException if divisor is zero
    public static  void divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        System.out.println("Result: "+a/b);
    }

    // Main method for testing the divide method
    public static void main(String[] args) {

        // Test normal division
        try {
            divide(10,2);// Expected output: 5
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }

        try {
            divide(10,0);// Expected output: 5
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }
}

package Day05_Regex_JUnit.JUnit.BasicJUnitTest;

public class Calculator {

    // Add method
    public int add(int a, int b) {
        return a + b;
    }

    // Subtract method
    public int subtract(int a, int b) {
        return a - b;
    }

    // Multiply method
    public int multiply(int a, int b) {
        return a * b;
    }

    // Divide method with exception handling for division by zero
    public double divide(int a, int b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return (double) a / b;
    }
}

package Day06_AnnotationsAndReflection.Reflection.IntermediateLevelProblems.DynamicMethodInvocation;

import java.lang.reflect.Method;
import java.util.Scanner;

public class MathOperations {

    // Method to add two numbers
    public int add(int a, int b) {
        return a + b;
    }

    // Method to subtract two numbers
    public int subtract(int a, int b) {
        return a - b;
    }

    // Method to multiply two numbers
    public int multiply(int a, int b) {
        return a * b;
    }

    public static void main(String[] args) {
        try {
            // Create a MathOperations instance
            MathOperations mathOperations = new MathOperations();

            // Take user input for the operation and the numbers
            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter the operation (add, subtract, multiply): ");
            String operation = scanner.nextLine();

            System.out.println("Enter the first number: ");
            int num1 = scanner.nextInt();

            System.out.println("Enter the second number: ");
            int num2 = scanner.nextInt();

            // Use Reflection to get the method based on user input
            Method method = MathOperations.class.getMethod(operation, int.class, int.class);

            // Dynamically invoke the method on the mathOperations object with the input numbers
            Object result = method.invoke(mathOperations, num1, num2);

            // Print the result
            System.out.println("Result: " + result);

            scanner.close();

        } catch (Exception e) {
            System.out.println("Enter Operation name: "+e.getMessage());
            e.printStackTrace();
        }
    }
}

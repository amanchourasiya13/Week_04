package Day06_AnnotationsAndReflection.Reflection.BasicLevelProblems.InvokePrivateMethod;

import java.lang.reflect.Method;

public class Calculator {
    // Private method that multiplies two integers
    private int multiply(int a, int b) {
        return a * b;
    }

    public static void main(String[] args) {
        try {
            // Create an instance of the Calculator class
            Calculator calculator = new Calculator();

            // Access the private method 'multiply' using reflection
            Method multiplyMethod = Calculator.class.getDeclaredMethod("multiply", int.class, int.class);

            // Make the private method accessible
            multiplyMethod.setAccessible(true);

            // Invoke the private method with arguments 5 and 3
            Object result = multiplyMethod.invoke(calculator, 5, 3);

            // Display the result
            System.out.println("Result of multiplication: " + result);

        } catch (NoSuchMethodException | IllegalAccessException | java.lang.reflect.InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}

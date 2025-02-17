package Day05_Regex_JUnit.JUnit.BasicJUnitTest;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    // Create an instance of Calculator
    Calculator calculator = new Calculator();

    // Test for addition
    @Test
    public void testAdd() {
        assertEquals(5, calculator.add(2, 3));  // 2 + 3 = 5
        assertEquals(-1, calculator.add(-2, 1)); // -2 + 1 = -1
        assertEquals(0, calculator.add(0, 0));  // 0 + 0 = 0
    }

    // Test for subtraction
    @Test
    public void testSubtract() {
        assertEquals(1, calculator.subtract(3, 2));  // 3 - 2 = 1
        assertEquals(-3, calculator.subtract(-2, 1)); // -2 - 1 = -3
        assertEquals(0, calculator.subtract(0, 0));  // 0 - 0 = 0
    }

    // Test for multiplication
    @Test
    public void testMultiply() {
        assertEquals(6, calculator.multiply(2, 3));  // 2 * 3 = 6
        assertEquals(-2, calculator.multiply(-2, 1)); // -2 * 1 = -2
        assertEquals(0, calculator.multiply(0, 5));  // 0 * 5 = 0
    }

    // Test for division
    @Test
    public void testDivide() {
        assertEquals(2.0, calculator.divide(6, 3));  // 6 / 3 = 2.0
        assertEquals(-2.0, calculator.divide(-6, 3)); // -6 / 3 = -2.0
        assertEquals(0.0, calculator.divide(0, 5));  // 0 / 5 = 0.0
    }

    // Test for division by zero
    @Test
    public void testDivideByZero() {
        ArithmeticException exception = assertThrows(ArithmeticException.class, () -> {
            calculator.divide(5, 0);  // Dividing by zero should throw an exception
        });
        assertEquals("Cannot divide by zero", exception.getMessage());  // Check the exception message
    }
}

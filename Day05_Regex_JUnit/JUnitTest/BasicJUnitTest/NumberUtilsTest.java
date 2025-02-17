//package Day05_Regex_JUnit.JUnit.BasicJUnitTest;
//
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.ValueSource;
//import static org.junit.jupiter.api.Assertions.*;
//
//public class NumberUtilsTest {
//
//    // Parameterized test to check if the number is even
//    @ParameterizedTest
//    @ValueSource(ints = {2, 4, 6}) // Test values: 2, 4, 6
//    public void testIsEvenWithEvenNumbers(int number) {
//        assertTrue(NumberUtils.isEven(number), "Expected number " + number + " to be even.");
//    }
//
//    // Parameterized test to check if the number is odd (should return false)
//    @ParameterizedTest
//    @ValueSource(ints = {7, 9}) // Test values: 7, 9
//    public void testIsEvenWithOddNumbers(int number) {
//        assertFalse(NumberUtils.isEven(number), "Expected number " + number + " to be odd.");
//    }
//}
//
//

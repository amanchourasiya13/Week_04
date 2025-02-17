package Day05_Regex_JUnit.JUnit.BasicJUnitTest;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringUtilsTest {

    // Test for reverse() method
    @Test
    public void testReverse() {
        assertEquals("gnitset", StringUtils.reverse("testing"));  // "testing" reversed is "gnitset"
        assertEquals("madam", StringUtils.reverse("madam"));  // "madam" reversed is "madam"
        assertEquals("abc", StringUtils.reverse("cba"));  // "cba" reversed is "abc"
        assertNull(StringUtils.reverse(null));  // Null input should return null
    }

    // Test for isPalindrome() method
    @Test
    public void testIsPalindrome() {
        assertTrue(StringUtils.isPalindrome("madam"));  // "madam" is a palindrome
        assertTrue(StringUtils.isPalindrome("racecar"));  // "racecar" is a palindrome
        assertFalse(StringUtils.isPalindrome("hello"));  // "hello" is not a palindrome
        assertFalse(StringUtils.isPalindrome("world"));  // "world" is not a palindrome
        assertFalse(StringUtils.isPalindrome(null));  // Null input should return false
    }

    // Test for toUpperCase() method
    @Test
    public void testToUpperCase() {
        assertEquals("HELLO", StringUtils.toUpperCase("hello"));  // "hello" to uppercase is "HELLO"
        assertEquals("WORLD", StringUtils.toUpperCase("world"));  // "world" to uppercase is "WORLD"
        assertEquals("JAVA", StringUtils.toUpperCase("java"));  // "java" to uppercase is "JAVA"
        assertNull(StringUtils.toUpperCase(null));  // Null input should return null
    }
}

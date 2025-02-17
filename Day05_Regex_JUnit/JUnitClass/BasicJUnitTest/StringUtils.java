package Day05_Regex_JUnit.JUnit.BasicJUnitTest;

public class StringUtils {

    // Method to reverse a string
    public static String reverse(String str) {
        if (str == null) {
            return null;
        }
        StringBuilder reversed = new StringBuilder(str);
        return reversed.reverse().toString();
    }

    // Method to check if a string is a palindrome
    public static boolean isPalindrome(String str) {
        if (str == null) {
            return false;
        }
        String reversed = reverse(str);
        return str.equals(reversed);
    }

    // Method to convert a string to uppercase
    public static String toUpperCase(String str) {
        if (str == null) {
            return null;
        }
        return str.toUpperCase();
    }

    // Main method to test the StringUtils class
    public static void main(String[] args) {
        // Test reverse method
        System.out.println("Reverse of 'testing': " + reverse("testing"));
        System.out.println("Reverse of 'madam': " + reverse("madam"));
        System.out.println("Reverse of 'cba': " + reverse("cba"));

        // Test isPalindrome method
        System.out.println("'madam' is palindrome: " + isPalindrome("madam"));
        System.out.println("'racecar' is palindrome: " + isPalindrome("racecar"));
        System.out.println("'hello' is palindrome: " + isPalindrome("hello"));

        // Test toUpperCase method
        System.out.println("'hello' in uppercase: " + toUpperCase("hello"));
        System.out.println("'world' in uppercase: " + toUpperCase("world"));
        System.out.println("'java' in uppercase: " + toUpperCase("java"));
    }
}


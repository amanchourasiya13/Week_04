package Day05_Regex_JUnit.JUnit.AdvanceJunit_PracticeProblems;

public class PasswordValidator {
    // Method to validate the password
    public static boolean isValidPassword(String password) {
        if (password == null || password.length() < 8) {
            return false; // Password must be at least 8 characters
        }

        boolean hasUpperCase = false;
        boolean hasDigit = false;

        // Check for at least one uppercase letter and one digit
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            }
            if (Character.isDigit(c)) {
                hasDigit = true;
            }
        }

        return hasUpperCase && hasDigit;
    }

    public static void main(String[] args) {
        // Testing valid password
        String validPassword = "Password123";
        System.out.println("Is 'Password123' valid? " + isValidPassword(validPassword));

        // Testing invalid password: no uppercase letter
        String invalidPassword1 = "password123";
        System.out.println("Is 'password123' valid? " + isValidPassword(invalidPassword1));

        // Testing invalid password: no digit
        String invalidPassword2 = "Password";
        System.out.println("Is 'Password' valid? " + isValidPassword(invalidPassword2));

        // Testing invalid password: too short
        String invalidPassword3 = "Pass1";
        System.out.println("Is 'Pass1' valid? " + isValidPassword(invalidPassword3));
    }
}


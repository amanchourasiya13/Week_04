package Day05_Regex_JUnit.JUnit.AdvanceJunit_PracticeProblems;

public class UserRegistration {

    public void registerUser(String username, String email, String password) {
        if (username == null || username.isEmpty()) {
            throw new IllegalArgumentException("Username cannot be empty");
        }

        if (email == null || !email.contains("@") || !email.contains(".")) {
            throw new IllegalArgumentException("Invalid email format");
        }

        if (password == null || password.length() < 6) {
            throw new IllegalArgumentException("Password must be at least 6 characters long");
        }

        // Here you can add more logic, like saving user to a database

        System.out.println("User registered successfully with username: " + username);
    }

    // Main method to demonstrate registration
    public static void main(String[] args) {
        UserRegistration userRegistration = new UserRegistration();

        // Example of valid registration
        try {
            userRegistration.registerUser("john_doe", "john.doe@example.com", "password123");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Example of invalid registration (empty username)
        try {
            userRegistration.registerUser("", "john.doe@example.com", "password123");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Example of invalid registration (invalid email format)
        try {
            userRegistration.registerUser("john_doe", "john.doe.com", "password123");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Example of invalid registration (short password)
        try {
            userRegistration.registerUser("john_doe", "john.doe@example.com", "pwd");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}


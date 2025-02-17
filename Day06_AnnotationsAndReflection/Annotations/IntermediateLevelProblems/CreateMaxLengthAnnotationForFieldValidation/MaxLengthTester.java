package Day06_AnnotationsAndReflection.Annotations.IntermediateLevelProblems.CreateMaxLengthAnnotationForFieldValidation;

public class MaxLengthTester {

    public static void main(String[] args) {
        try {
            // This should succeed (username length <= 10)
            User user1 = new User("shortUser");
            System.out.println("User1 created with username: " + user1.getUsername());

            // This should throw an exception (username length > 10)
            User user2 = new User("ThisIsTooLong");
            System.out.println("User2 created with username: " + user2.getUsername());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}


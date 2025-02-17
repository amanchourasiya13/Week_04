package Day06_AnnotationsAndReflection.Annotations.IntermediateLevelProblems.CreateMaxLengthAnnotationForFieldValidation;

public class User {

    @MaxLength(value = 10)  // Maximum username length is 10 characters
    private String username;

    public User(String username) {
        // Validate the username length
        MaxLength maxLengthAnnotation = this.getClass().getDeclaredFields()[0].getAnnotation(MaxLength.class);
        if (maxLengthAnnotation != null) {
            int maxLength = maxLengthAnnotation.value();
            if (username.length() > maxLength) {
                throw new IllegalArgumentException("Username length exceeds the maximum limit of " + maxLength);
            }
        }
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}

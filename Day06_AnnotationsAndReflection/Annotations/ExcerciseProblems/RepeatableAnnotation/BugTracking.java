package Day06_AnnotationsAndReflection.Annotations.ExcerciseProblems.RepeatableAnnotation;


public class BugTracking {

    @BugReport(description = "Null pointer exception when accessing user profile.")
    @BugReport(description = "Array index out of bounds exception when adding new users.")
    public void processUserData() {
        // Some implementation code
    }
}
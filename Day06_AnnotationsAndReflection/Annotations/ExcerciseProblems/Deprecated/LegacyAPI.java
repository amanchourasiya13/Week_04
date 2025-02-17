package Day06_AnnotationsAndReflection.Annotations.ExcerciseProblems.Deprecated;

// LegacyAPI class with old and new methods
public class LegacyAPI {

    // Old method marked as deprecated
    @Deprecated
    public void oldFeature() {
        System.out.println("This is the old feature. It is deprecated.");
    }

    // New method to replace the old feature
    public void newFeature() {
        System.out.println("This is the new feature. Use this instead.");
    }

    public static void main(String[] args) {
        // Creating an instance of LegacyAPI
        LegacyAPI api = new LegacyAPI();

        // Calling the deprecated oldFeature method
        api.oldFeature(); // This will show a deprecation warning

        // Calling the newFeature method
        api.newFeature();
    }
}


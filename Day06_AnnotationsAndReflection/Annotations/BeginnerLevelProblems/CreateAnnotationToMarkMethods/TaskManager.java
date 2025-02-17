package Day06_AnnotationsAndReflection.Annotations.BeginnerLevelProblems.CreateAnnotationToMarkMethods;

public class TaskManager {

    @ImportantMethod(level = "HIGH")  // Method marked with HIGH importance
    public void processCriticalTask() {
        System.out.println("Processing critical task...");
    }

    @ImportantMethod(level = "LOW")  // Method marked with LOW importance
    public void processMinorTask() {
        System.out.println("Processing minor task...");
    }

    @ImportantMethod()  // Method marked with default HIGH importance
    public void processRoutineTask() {
        System.out.println("Processing routine task...");
    }
}


package Day06_AnnotationsAndReflection.Annotations.ExcerciseProblems.CustomAnnotation;

public class TaskManager {

    // Apply the custom @TaskInfo annotation to the method
    @TaskInfo(priority = "High", assignedTo = "John Doe")
    public void completeTask() {
        System.out.println("Task is being completed.");
    }

    // Another method without the custom annotation
    public void anotherTask() {
        System.out.println("Another task.");
    }
}

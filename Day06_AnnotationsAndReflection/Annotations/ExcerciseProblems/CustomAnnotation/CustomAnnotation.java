package Day06_AnnotationsAndReflection.Annotations.ExcerciseProblems.CustomAnnotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class CustomAnnotation {
    public static void main(String[] args) {
        // Get the TaskManager class
        Class<TaskManager> taskManagerClass = TaskManager.class;

        // Iterate over all methods in the TaskManager class
        for (Method method : taskManagerClass.getDeclaredMethods()) {

            // Check if the method has the @TaskInfo annotation
            if (method.isAnnotationPresent(TaskInfo.class)) {

                // Retrieve the annotation instance
                TaskInfo taskInfo = method.getAnnotation(TaskInfo.class);

                // Display the annotation details
                System.out.println("Method: " + method.getName());
                System.out.println("Priority: " + taskInfo.priority());
                System.out.println("Assigned To: " + taskInfo.assignedTo());
                System.out.println("-------------------------------");
            }
        }
    }
}

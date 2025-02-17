package Day06_AnnotationsAndReflection.Annotations.BeginnerLevelProblems.CreateTodoAnnotationForPendingTasks;

import java.lang.reflect.Method;

public class TodoTester {

    public static void main(String[] args) {
        try {
            // Get all methods of the ProjectTasks class
            Method[] methods = ProjectTasks.class.getDeclaredMethods();

            // Iterate through each method and check if it's annotated with @Todo
            for (Method method : methods) {
                if (method.isAnnotationPresent(Todo.class)) {
                    // Get the @Todo annotation on the method
                    Todo todo = method.getAnnotation(Todo.class);

                    // Print the task details
                    System.out.println("Task: " + todo.task());
                    System.out.println("Assigned To: " + todo.assignedTo());
                    System.out.println("Priority: " + todo.priority());
                    System.out.println();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


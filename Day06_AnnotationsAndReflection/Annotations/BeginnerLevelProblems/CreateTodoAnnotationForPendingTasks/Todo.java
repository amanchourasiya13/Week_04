package Day06_AnnotationsAndReflection.Annotations.BeginnerLevelProblems.CreateTodoAnnotationForPendingTasks;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Todo {
    String task();         // Description of the task
    String assignedTo();   // Developer responsible
    String priority() default "MEDIUM"; // Default priority is MEDIUM
}


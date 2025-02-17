package Day06_AnnotationsAndReflection.Annotations.ExcerciseProblems.CustomAnnotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// Custom annotation TaskInfo with fields priority and assignedTo
@Retention(RetentionPolicy.RUNTIME) // Retention policy set to runtime for reflection usage
public @interface TaskInfo {
    String priority() default "Low";  // Default priority is "Low"
    String assignedTo() default "Unassigned"; // Default assigned person is "Unassigned"
}


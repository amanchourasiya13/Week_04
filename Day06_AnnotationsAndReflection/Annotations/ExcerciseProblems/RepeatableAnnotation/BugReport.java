package Day06_AnnotationsAndReflection.Annotations.ExcerciseProblems.RepeatableAnnotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(BugReports.class)  // Allow the annotation to be repeatable
public @interface BugReport {
    String description();
}


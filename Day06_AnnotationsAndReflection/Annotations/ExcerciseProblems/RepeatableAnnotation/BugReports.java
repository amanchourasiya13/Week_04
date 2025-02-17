package Day06_AnnotationsAndReflection.Annotations.ExcerciseProblems.RepeatableAnnotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface BugReports {
    BugReport[] value();
}

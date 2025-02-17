package Day06_AnnotationsAndReflection.Annotations.BeginnerLevelProblems.CreateAnnotationToMarkMethods;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ImportantMethod {
    String level() default "HIGH";  // Optional parameter with a default value of "HIGH"
}

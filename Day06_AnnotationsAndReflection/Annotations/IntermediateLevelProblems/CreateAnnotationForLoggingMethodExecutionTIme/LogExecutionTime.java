package Day06_AnnotationsAndReflection.Annotations.IntermediateLevelProblems.CreateAnnotationForLoggingMethodExecutionTIme;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface LogExecutionTime {
    // Marker annotation with no properties
}

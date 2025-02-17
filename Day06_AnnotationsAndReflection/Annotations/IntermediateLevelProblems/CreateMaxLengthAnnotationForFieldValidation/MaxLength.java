package Day06_AnnotationsAndReflection.Annotations.IntermediateLevelProblems.CreateMaxLengthAnnotationForFieldValidation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface MaxLength {
    int value();  // The maximum allowed length for the annotated field
}

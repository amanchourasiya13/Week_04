package Day06_AnnotationsAndReflection.Annotations.AdvanceLevelProblems.CustomSerializationAnnotation_JsonField;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)  // Apply to fields
@Retention(RetentionPolicy.RUNTIME)  // Retain at runtime for reflection
public @interface JsonField {
    String name();  // Custom name for JSON serialization
}

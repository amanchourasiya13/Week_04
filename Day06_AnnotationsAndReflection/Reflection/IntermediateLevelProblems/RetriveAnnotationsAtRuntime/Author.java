package Day06_AnnotationsAndReflection.Reflection.IntermediateLevelProblems.RetriveAnnotationsAtRuntime;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// Define a custom annotation with a 'name' element
@Retention(RetentionPolicy.RUNTIME)  // Make sure the annotation is available at runtime
public @interface Author {
    String name();
}

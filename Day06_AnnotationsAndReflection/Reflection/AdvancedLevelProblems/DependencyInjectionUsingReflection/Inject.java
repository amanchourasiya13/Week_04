package Day06_AnnotationsAndReflection.Reflection.AdvancedLevelProblems.DependencyInjectionUsingReflection;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD) // Can be applied only to fields
@Retention(RetentionPolicy.RUNTIME) // Retain at runtime for reflection
public @interface Inject {
}

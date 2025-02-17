package Day06_AnnotationsAndReflection.Annotations.AdvanceLevelProblems.RoleBasedAccessControlWith_RoleAllowed;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)  // Applies to methods
@Retention(RetentionPolicy.RUNTIME)  // Available at runtime for reflection
public @interface RoleAllowed {
    String value();  // The role that is allowed to access the method
}

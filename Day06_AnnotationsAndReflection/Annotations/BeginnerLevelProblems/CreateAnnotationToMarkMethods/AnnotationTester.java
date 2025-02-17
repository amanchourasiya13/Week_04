package Day06_AnnotationsAndReflection.Annotations.BeginnerLevelProblems.CreateAnnotationToMarkMethods;

import java.lang.reflect.Method;

public class AnnotationTester {

    public static void main(String[] args) {
        try {
            // Get all methods of the TaskManager class
            Method[] methods = TaskManager.class.getDeclaredMethods();

            // Iterate through each method and check if it's annotated with @ImportantMethod
            for (Method method : methods) {
                if (method.isAnnotationPresent(ImportantMethod.class)) {
                    // Get the annotation for the method
                    ImportantMethod importantMethod = method.getAnnotation(ImportantMethod.class);

                    // Print method details
                    System.out.println("Method: " + method.getName());
                    System.out.println("Importance Level: " + importantMethod.level());
                    System.out.println();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

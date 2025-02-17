package Day06_AnnotationsAndReflection.Annotations.IntermediateLevelProblems.CreateAnnotationForLoggingMethodExecutionTIme;

import java.lang.annotation.*;
import java.lang.reflect.Method;

public class ExecutionTimeLogger {

    // Method to log execution time
    public static void logExecutionTime(Object object, String methodName, Object... args) throws Exception {
        // Get the method by name and parameter types
        Method method = object.getClass().getDeclaredMethod(methodName);

        // Check if the method is annotated with @LogExecutionTime
        if (method.isAnnotationPresent(LogExecutionTime.class)) {
            long startTime = System.nanoTime(); // Start time before method execution

            // Invoke the method
            method.setAccessible(true);
            method.invoke(object, args);

            long endTime = System.nanoTime(); // End time after method execution
            long executionTime = endTime - startTime; // Calculate execution time

            System.out.println("Method: " + method.getName() + " executed in: " + executionTime + " nanoseconds.");
        }
    }
}

package Day06_AnnotationsAndReflection.Reflection.AdvancedLevelProblems.MethodExecutionTiming;

import java.lang.reflect.Method;

public class MethodExecutionTimer {

    public static void main(String[] args) {
        MyClass myClass = new MyClass();

        // Get all methods of the class
        Method[] methods = MyClass.class.getDeclaredMethods();

        for (Method method : methods) {
            try {
                // Record the start time
                long startTime = System.nanoTime();

                // Invoke the method dynamically
                method.setAccessible(true);  // In case the method is private
                method.invoke(myClass);

                // Record the end time
                long endTime = System.nanoTime();

                // Calculate the execution time
                long executionTime = endTime - startTime;

                // Print the method name and execution time
                System.out.println("Execution time of " + method.getName() + ": " + executionTime + " nanoseconds");

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}




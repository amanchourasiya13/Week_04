package Day06_AnnotationsAndReflection.Annotations.AdvanceLevelProblems.CustomCachingSystem_CacheResult;

import java.lang.reflect.Method;

public class ExpensiveComputation {

    // Annotated with @CacheResult to enable caching
    @CacheResult
    public int slowMethod(int input) {
        try {
            System.out.println("Computing result for input: " + input);
            Thread.sleep(2000);  // Simulate a time-consuming operation (e.g., network call or heavy computation)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return input * input;  // Simulate a computation (e.g., squaring the input)
    }

    // Method to invoke the annotated method with caching
    public Object invokeWithCaching(Method method, Object[] args) {
        if (method.isAnnotationPresent(CacheResult.class)) {
            return CacheManager.getCachedResult(this, method, args);
        }
        try {
            return method.invoke(this, args);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        ExpensiveComputation computation = new ExpensiveComputation();
        try {
            Method slowMethod = ExpensiveComputation.class.getMethod("slowMethod", int.class);

            // Call the slow method multiple times to test caching
            System.out.println("Result: " + computation.invokeWithCaching(slowMethod, new Object[]{5}));
            System.out.println("Result: " + computation.invokeWithCaching(slowMethod, new Object[]{5}));  // Cached result
            System.out.println("Result: " + computation.invokeWithCaching(slowMethod, new Object[]{10}));
            System.out.println("Result: " + computation.invokeWithCaching(slowMethod, new Object[]{10}));  // Cached result
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}

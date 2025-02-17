package Day06_AnnotationsAndReflection.Reflection.AdvancedLevelProblems.LoggingProxyUsingReflection;

public class GreetingImpl implements Greeting {
    @Override
    public void sayHello() {
        System.out.println("Hello!");
    }

    @Override
    public void sayGoodbye() {
        System.out.println("Goodbye!");
    }
}

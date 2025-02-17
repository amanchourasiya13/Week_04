package Day06_AnnotationsAndReflection.Reflection.AdvancedLevelProblems.LoggingProxyUsingReflection;

import java.lang.reflect.Proxy;

public class DynamicProxyExample {
    public static void main(String[] args) {
        // Create the original object (GreetingImpl)
        Greeting greeting = new GreetingImpl();

        // Create the logging proxy that intercepts method calls
        Greeting proxy = (Greeting) Proxy.newProxyInstance(
                Greeting.class.getClassLoader(),
                new Class[]{Greeting.class},
                new LoggingInvocationHandler(greeting)
        );

        // Call methods on the proxy (logging will be done before execution)
        proxy.sayHello();
        proxy.sayGoodbye();
    }
}

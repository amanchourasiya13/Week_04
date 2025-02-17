package Day06_AnnotationsAndReflection.Reflection.AdvancedLevelProblems.LoggingProxyUsingReflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LoggingInvocationHandler implements InvocationHandler {
    private Object target;

    // Constructor accepts the target object to which method calls will be delegated
    public LoggingInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // Log the method name before execution
        System.out.println("Method called: " + method.getName());

        // Delegate the actual method call to the target object
        return method.invoke(target, args);
    }
}

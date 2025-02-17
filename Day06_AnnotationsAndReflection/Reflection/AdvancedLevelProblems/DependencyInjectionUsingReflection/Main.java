package Day06_AnnotationsAndReflection.Reflection.AdvancedLevelProblems.DependencyInjectionUsingReflection;

public class Main {
    public static void main(String[] args) throws Exception {
        // Create the DI container
        DIContainer diContainer = new DIContainer();

        // Get an instance of GreetingService with its dependency injected
        GreetingService greetingService = diContainer.getInstance(GreetingService.class);

        // Call the greet method which uses the injected MessageService
        greetingService.greet();
    }
}


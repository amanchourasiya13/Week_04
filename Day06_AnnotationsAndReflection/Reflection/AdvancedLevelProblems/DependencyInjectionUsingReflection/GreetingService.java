package Day06_AnnotationsAndReflection.Reflection.AdvancedLevelProblems.DependencyInjectionUsingReflection;

public class GreetingService {
    private final MessageService messageService;

    // Constructor-based injection for the MessageService
    public GreetingService(MessageService messageService) {
        this.messageService = messageService;
    }

    // Method to use the injected dependency
    public void greet() {
        System.out.println(messageService.getMessage());
    }
}


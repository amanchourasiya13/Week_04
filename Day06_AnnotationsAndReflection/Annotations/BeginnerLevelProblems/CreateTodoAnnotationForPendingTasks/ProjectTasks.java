package Day06_AnnotationsAndReflection.Annotations.BeginnerLevelProblems.CreateTodoAnnotationForPendingTasks;

public class ProjectTasks {

    @Todo(task = "Implement user authentication", assignedTo = "Alice", priority = "HIGH")
    public void implementAuthentication() {
        // Placeholder for method implementation
    }

    @Todo(task = "Design database schema", assignedTo = "Bob", priority = "MEDIUM")
    public void designDatabase() {
        // Placeholder for method implementation
    }

    @Todo(task = "Create API documentation", assignedTo = "Charlie", priority = "LOW")
    public void createApiDocs() {
        // Placeholder for method implementation
    }

    @Todo(task = "Set up CI/CD pipeline", assignedTo = "Dave")  // Default priority (MEDIUM)
    public void setupCICD() {
        // Placeholder for method implementation
    }
}

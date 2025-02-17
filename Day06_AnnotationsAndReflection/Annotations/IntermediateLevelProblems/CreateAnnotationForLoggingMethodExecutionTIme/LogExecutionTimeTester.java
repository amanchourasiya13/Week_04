package Day06_AnnotationsAndReflection.Annotations.IntermediateLevelProblems.CreateAnnotationForLoggingMethodExecutionTIme;

public class LogExecutionTimeTester {

    public static void main(String[] args) {
        TaskProcessor taskProcessor = new TaskProcessor();

        try {
            // Measure execution time of methods with @LogExecutionTime
            ExecutionTimeLogger.logExecutionTime(taskProcessor, "processLargeTask");
            ExecutionTimeLogger.logExecutionTime(taskProcessor, "processSmallTask");

            // Call method without annotation (this won't log execution time)
            taskProcessor.processNoAnnotationTask();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

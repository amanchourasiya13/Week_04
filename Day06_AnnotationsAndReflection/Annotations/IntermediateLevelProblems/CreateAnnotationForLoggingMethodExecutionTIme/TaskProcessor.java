package Day06_AnnotationsAndReflection.Annotations.IntermediateLevelProblems.CreateAnnotationForLoggingMethodExecutionTIme;

public class TaskProcessor {

    @LogExecutionTime
    public void processLargeTask() {
        try {
            Thread.sleep(500);  // Simulate a time-consuming task (500 milliseconds)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @LogExecutionTime
    public void processSmallTask() {
        try {
            Thread.sleep(100);  // Simulate a shorter task (100 milliseconds)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void processNoAnnotationTask() {
        try {
            Thread.sleep(200);  // Simulate a task that is not annotated
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


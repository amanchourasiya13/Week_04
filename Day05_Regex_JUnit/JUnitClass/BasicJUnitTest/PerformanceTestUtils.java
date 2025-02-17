package Day05_Regex_JUnit.JUnit.BasicJUnitTest;

public class PerformanceTestUtils {

    // Method that simulates a long-running task
    public static String longRunningTask() throws InterruptedException {
        // Simulate a task that takes 3 seconds to complete
        Thread.sleep(3000);  // Sleep for 3 seconds
        return "Task Completed";
    }

    // Main method to test longRunningTask manually
    public static void main(String[] args) {
        try {
            // Call longRunningTask manually
            String result = longRunningTask();
            System.out.println(result); // Expected output: "Task Completed"
        } catch (InterruptedException e) {
            System.err.println("Task was interrupted: " + e.getMessage());
        }
    }
}

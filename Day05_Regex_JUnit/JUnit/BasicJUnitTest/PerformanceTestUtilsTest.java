package Day05_Regex_JUnit.JUnit.BasicJUnitTest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.junit.jupiter.api.Assertions.*;

public class PerformanceTestUtilsTest {

    // Test with @Timeout(5) which gives more time for the method to complete
    @Test
    @Timeout(5)  // Timeout set to 5 seconds
    public void testLongRunningTask() throws InterruptedException {
        String result = PerformanceTestUtils.longRunningTask();
        assertEquals("Task Completed", result);
    }
}

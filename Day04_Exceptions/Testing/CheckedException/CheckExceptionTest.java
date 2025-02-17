package Day04_Exceptions.CheckedException;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CheckExceptionTest {

    @Test
    void testCheckExceptionWithValidFile() {
        // Assuming you have a valid "info.txt" in your project
        CheckException.checKException("src/main/java/Day04_Exceptions/info.txt");
        // You can also validate the output in your tests by capturing the output streams if needed
    }

    @Test
    void testCheckExceptionWithInvalidFile() {
        // Test with an invalid file path to trigger FileNotFoundException
        CheckException.checKException("src/main/java/Day04_Exceptions/CheckedException/nonexistentfile.txt");
    }
}

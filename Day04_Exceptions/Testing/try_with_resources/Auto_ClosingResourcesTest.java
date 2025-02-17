package Day04_Exceptions.try_with_resources;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Auto_ClosingResourcesTest {

    @Test
    void testCheckExceptionWithValidFile() {
        // Assuming "info.txt" is a valid file in the correct path
        Auto_ClosingResources.checKException("src/main/java/Day04_Exceptions/try_with_resources/info.txt");
    }

    @Test
    void testCheckExceptionWithEmptyFile() {
        // Test with an empty file to check the empty file message
        Auto_ClosingResources.checKException("src/main/java/Day04_Exceptions/try_with_resources/emptyfile.txt");
    }

    @Test
    void testCheckExceptionWithInvalidFile() {
        // Test with a nonexistent file to trigger an error message
        Auto_ClosingResources.checKException("src/main/java/Day04_Exceptions/try_with_resources/nontfile.txt");
    }
}

package Day05_Regex_JUnit.Regex.AdvancedProblems;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class IPValidatorTest {

    @Test
    public void testValidIP() {
        assertTrue(IPValidator.isValidIP("192.168.0.1"));
        assertTrue(IPValidator.isValidIP("0.0.0.0"));
    }

    @Test
    public void testInvalidIP() {
        assertFalse(IPValidator.isValidIP("256.256.256.256"));
        assertFalse(IPValidator.isValidIP("192.168.256.1"));
        assertFalse(IPValidator.isValidIP("999.999.999.999"));
        assertFalse(IPValidator.isValidIP("192.168.1.1."));
        assertFalse(IPValidator.isValidIP("192.168.1"));
        assertFalse(IPValidator.isValidIP("abc.def.ghi.jkl"));
    }
}

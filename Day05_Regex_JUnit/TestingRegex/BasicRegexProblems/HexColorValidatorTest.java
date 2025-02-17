package Day05_Regex_JUnit.Regex.BasicRegexProblems;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HexColorValidatorTest {

    @Test
    public void testValidHexColor() {
        assertTrue(HexColorValidator.isValidHexColor("#FFA500"));
        assertTrue(HexColorValidator.isValidHexColor("#ff4500"));
        assertTrue(HexColorValidator.isValidHexColor("#abcdef"));
    }

    @Test
    public void testInvalidHexColor() {
        assertFalse(HexColorValidator.isValidHexColor("#123"));
        assertFalse(HexColorValidator.isValidHexColor("#XYZ123"));
        assertFalse(HexColorValidator.isValidHexColor("FFA500"));
        assertFalse(HexColorValidator.isValidHexColor("#ff45g0"));
    }
}

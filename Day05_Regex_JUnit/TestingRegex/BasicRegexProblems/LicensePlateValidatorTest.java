package Day05_Regex_JUnit.Regex.BasicRegexProblems;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LicensePlateValidatorTest {

    @Test
    public void testValidLicensePlate() {
        assertTrue(LicensePlateValidator.isValidLicensePlate("AB1234"));
        assertTrue(LicensePlateValidator.isValidLicensePlate("XY5678"));
    }

    @Test
    public void testInvalidLicensePlate() {
        assertFalse(LicensePlateValidator.isValidLicensePlate("A12345"));
        assertFalse(LicensePlateValidator.isValidLicensePlate("AB123"));
        assertFalse(LicensePlateValidator.isValidLicensePlate("ab1234"));
        assertFalse(LicensePlateValidator.isValidLicensePlate("123456"));
    }
}

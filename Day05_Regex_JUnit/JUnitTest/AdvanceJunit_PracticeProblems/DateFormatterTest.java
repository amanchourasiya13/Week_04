package Day05_Regex_JUnit.JUnit.AdvanceJunit_PracticeProblems;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DateFormatterTest {

    // Test valid date
    @Test
    void testValidDate() {
        assertEquals("15-02-2025", DateFormatter.formatDate("2025-02-15"), "The date should be formatted correctly.");
    }

    // Test invalid date (wrong format)
    @Test
    void testInvalidDateFormat() {
        assertEquals("Invalid date format", DateFormatter.formatDate("15-02-2025"), "The date format is invalid.");
    }

    // Test empty string as input
    @Test
    void testEmptyString() {
        assertEquals("Invalid date format", DateFormatter.formatDate(""), "Empty string should return invalid format.");
    }

    // Test null input
    @Test
    void testNullDate() {
        assertEquals("Invalid date format", DateFormatter.formatDate(null), "Null input should return invalid format.");
    }

    // Test invalid date (nonexistent date, e.g., 2025-02-30)
    @Test
    void testNonexistentDate() {
        assertEquals("Invalid date format", DateFormatter.formatDate("2025-02-30"), "Nonexistent dates should be considered invalid.");
    }
}

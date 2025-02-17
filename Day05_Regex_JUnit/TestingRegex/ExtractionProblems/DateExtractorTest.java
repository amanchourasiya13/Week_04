package Day05_Regex_JUnit.Regex.ExtractionProblems;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class DateExtractorTest {

    @Test
    public void testExtractDates() {
        // Test with a sentence containing multiple dates
        String text1 = "The events are scheduled for 12/05/2023, 15/08/2024, and 29/02/2020.";
        List<String> result1 = DateExtractor.extractDates(text1);
        assertEquals(3, result1.size());
        assertTrue(result1.contains("12/05/2023"));
        assertTrue(result1.contains("15/08/2024"));
        assertTrue(result1.contains("29/02/2020"));

        // Test with no dates
        String text2 = "There are no dates here.";
        List<String> result2 = DateExtractor.extractDates(text2);
        assertTrue(result2.isEmpty());

        // Test with a sentence containing invalid date formats
        String text3 = "Invalid dates: 31/13/2023, 32/01/2022.";
        List<String> result3 = DateExtractor.extractDates(text3);
        assertTrue(result3.isEmpty());

        // Test with dates that follow the correct format but are in different months and years
        String text4 = "Important deadlines: 01/01/2025, 28/12/2023.";
        List<String> result4 = DateExtractor.extractDates(text4);
        assertEquals(2, result4.size());
        assertTrue(result4.contains("01/01/2025"));
        assertTrue(result4.contains("28/12/2023"));
    }
}

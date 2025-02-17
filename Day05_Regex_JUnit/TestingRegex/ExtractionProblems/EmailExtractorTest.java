package Day05_Regex_JUnit.Regex.ExtractionProblems;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class EmailExtractorTest {

    @Test
    public void testExtractEmails() {
        // Test with a sentence containing multiple emails
        String text1 = "Contact us at support@example.com and info@company.org";
        List<String> result1 = EmailExtractor.extractEmails(text1);
        assertEquals(2, result1.size());
        assertTrue(result1.contains("support@example.com"));
        assertTrue(result1.contains("info@company.org"));

        // Test with no email addresses
        String text2 = "This text has no emails.";
        List<String> result2 = EmailExtractor.extractEmails(text2);
        assertTrue(result2.isEmpty());

        // Test with emails in various formats
        String text3 = "You can reach us at john.doe@domain.com, admin123@website.co.uk.";
        List<String> result3 = EmailExtractor.extractEmails(text3);
        assertEquals(2, result3.size());
        assertTrue(result3.contains("john.doe@domain.com"));
        assertTrue(result3.contains("admin123@website.co.uk"));

        // Test with an email that has an invalid format
        String text4 = "Invalid email: user@domain";
        List<String> result4 = EmailExtractor.extractEmails(text4);
        assertTrue(result4.isEmpty());
    }
}

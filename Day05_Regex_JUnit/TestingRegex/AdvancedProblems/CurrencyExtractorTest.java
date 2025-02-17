package Day05_Regex_JUnit.Regex.AdvancedProblems;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class CurrencyExtractorTest {

    @Test
    public void testExtractCurrencyValues() {
        // Test case 1: Example text with currency values
        String text1 = "The price is $45.99, and the discount is 10.50.";
        List<String> currencies1 = CurrencyExtractor.extractCurrencyValues(text1);
        assertEquals(2, currencies1.size());
        assertTrue(currencies1.contains("$45.99"));
        assertTrue(currencies1.contains("10.50"));

        // Test case 2: Text without currency values
        String text2 = "No prices here!";
        List<String> currencies2 = CurrencyExtractor.extractCurrencyValues(text2);
        assertEquals(0, currencies2.size());

        // Test case 3: Text with multiple currency values
        String text3 = "Prices are $100, $50.99, and 30.";
        List<String> currencies3 = CurrencyExtractor.extractCurrencyValues(text3);
        assertEquals(3, currencies3.size());
        assertTrue(currencies3.contains("$100"));
        assertTrue(currencies3.contains("$50.99"));
        assertTrue(currencies3.contains("30"));
    }
}

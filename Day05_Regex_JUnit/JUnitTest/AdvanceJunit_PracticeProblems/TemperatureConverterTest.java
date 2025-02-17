package Day05_Regex_JUnit.JUnit.AdvanceJunit_PracticeProblems;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TemperatureConverterTest {

    // Test Celsius to Fahrenheit conversion
    @Test
    void testCelsiusToFahrenheit() {
        assertEquals(77.0, TemperatureConverter.celsiusToFahrenheit(25.0), "25°C should be 77°F.");
        assertEquals(32.0, TemperatureConverter.celsiusToFahrenheit(0.0), "0°C should be 32°F.");
        assertEquals(-58.0, TemperatureConverter.celsiusToFahrenheit(-50.0), "-50°C should be -58°F.");
    }

    // Test Fahrenheit to Celsius conversion
    @Test
    void testFahrenheitToCelsius() {
        assertEquals(25.0, TemperatureConverter.fahrenheitToCelsius(77.0), "77°F should be 25°C.");
        assertEquals(0.0, TemperatureConverter.fahrenheitToCelsius(32.0), "32°F should be 0°C.");
        assertEquals(-50.0, TemperatureConverter.fahrenheitToCelsius(-58.0), "-58°F should be -50°C.");
    }

    // Test extreme temperatures
    @Test
    void testExtremeTemperatures() {
        assertEquals(212.0, TemperatureConverter.celsiusToFahrenheit(100.0), "100°C should be 212°F.");
        assertEquals(-40.0, TemperatureConverter.fahrenheitToCelsius(-40.0), "-40°F should be -40°C.");
    }
}

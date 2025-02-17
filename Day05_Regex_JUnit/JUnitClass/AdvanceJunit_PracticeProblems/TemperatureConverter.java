package Day05_Regex_JUnit.JUnit.AdvanceJunit_PracticeProblems;

public class TemperatureConverter {

    // Method to convert Celsius to Fahrenheit
    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9/5) + 32;
    }

    // Method to convert Fahrenheit to Celsius
    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5/9;
    }

    // Main method for direct testing
    public static void main(String[] args) {
        // Testing celsiusToFahrenheit
        double celsius = 25.0;
        double fahrenheit = celsiusToFahrenheit(celsius);
        System.out.println(celsius + "°C = " + fahrenheit + "°F");

        // Testing fahrenheitToCelsius
        fahrenheit = 77.0;
        celsius = fahrenheitToCelsius(fahrenheit);
        System.out.println(fahrenheit + "°F = " + celsius + "°C");

        // Additional test cases
        System.out.println("-50°C = " + celsiusToFahrenheit(-50) + "°F");
        System.out.println("32°F = " + fahrenheitToCelsius(32) + "°C");
    }
}


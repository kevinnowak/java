package com.github.kevinnowak.basics.temperature_converter;

/**
 * A utility class for converting temperatures between Celsius and Fahrenheit.
 */
public class TemperatureConverter {

    /**
     * Converts a temperature from Celsius to Fahrenheit.
     * <p>
     * The formula for converting Celsius to Fahrenheit is:
     * F = C * 9/5 + 32
     *
     * @param celsius The temperature in Celsius.
     * @return The temperature in Fahrenheit.
     */
    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    /**
     * Converts a temperature from Fahrenheit to Celsius.
     * <p>
     * The formula for converting Fahrenheit to Celsius is:
     * C = (F - 32) * 5/9
     *
     * @param fahrenheit The temperature in Fahrenheit.
     * @return The temperature in Celsius.
     */
    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    public static void main(String[] args) {
        double celsius = 25.0;
        double fahrenheit = TemperatureConverter.celsiusToFahrenheit(celsius);
        System.out.printf("%.1f°C is %.1f°F%n", celsius, fahrenheit); // Expected: 25.0°C is 77.0°F

        fahrenheit = 68.0;
        celsius = TemperatureConverter.fahrenheitToCelsius(fahrenheit);
        System.out.printf("%.1f°F is %.1f°C%n", fahrenheit, celsius); // Expected: 68.0°F is 20.0°C
    }
}

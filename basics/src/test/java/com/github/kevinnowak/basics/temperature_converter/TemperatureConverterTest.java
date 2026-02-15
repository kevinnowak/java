package com.github.kevinnowak.basics.temperature_converter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TemperatureConverterTest {

    private static final double DELTA = 0.001; // For double comparisons

    @Test
    @DisplayName("Should convert 0°C to 32°F")
    void celsiusToFahrenheit_zeroCelsius_returnsThirtyTwoFahrenheit() {
        double celsius = 0.0;
        double expectedFahrenheit = 32.0;
        double actualFahrenheit = TemperatureConverter.celsiusToFahrenheit(celsius);
        assertEquals(expectedFahrenheit, actualFahrenheit, DELTA);
    }

    @Test
    @DisplayName("Should convert 100°C to 212°F (Boiling point)")
    void celsiusToFahrenheit_boilingPointCelsius_returnsBoilingPointFahrenheit() {
        double celsius = 100.0;
        double expectedFahrenheit = 212.0;
        double actualFahrenheit = TemperatureConverter.celsiusToFahrenheit(celsius);
        assertEquals(expectedFahrenheit, actualFahrenheit, DELTA);
    }

    @Test
    @DisplayName("Should convert -40°C to -40°F (Conversion equality)")
    void celsiusToFahrenheit_minusFortyCelsius_returnsMinusFortyFahrenheit() {
        double celsius = -40.0;
        double expectedFahrenheit = -40.0;
        double actualFahrenheit = TemperatureConverter.celsiusToFahrenheit(celsius);
        assertEquals(expectedFahrenheit, actualFahrenheit, DELTA);
    }

    @Test
    @DisplayName("Should convert 32°F to 0°C")
    void fahrenheitToCelsius_thirtyTwoFahrenheit_returnsZeroCelsius() {
        double fahrenheit = 32.0;
        double expectedCelsius = 0.0;
        double actualCelsius = TemperatureConverter.fahrenheitToCelsius(fahrenheit);
        assertEquals(expectedCelsius, actualCelsius, DELTA);
    }

    @Test
    @DisplayName("Should convert 212°F to 100°C (Boiling point)")
    void fahrenheitToCelsius_boilingPointFahrenheit_returnsBoilingPointCelsius() {
        double fahrenheit = 212.0;
        double expectedCelsius = 100.0;
        double actualCelsius = TemperatureConverter.fahrenheitToCelsius(fahrenheit);
        assertEquals(expectedCelsius, actualCelsius, DELTA);
    }

    @Test
    @DisplayName("Should convert -40°F to -40°C (Conversion equality)")
    void fahrenheitToCelsius_minusFortyFahrenheit_returnsMinusFortyCelsius() {
        double fahrenheit = -40.0;
        double expectedCelsius = -40.0;
        double actualCelsius = TemperatureConverter.fahrenheitToCelsius(fahrenheit);
        assertEquals(expectedCelsius, actualCelsius, DELTA);
    }

    @Test
    @DisplayName("Should handle fractional temperatures from Celsius to Fahrenheit")
    void celsiusToFahrenheit_fractionalCelsius_returnsCorrectFahrenheit() {
        double celsius = 25.5;
        double expectedFahrenheit = 77.9;
        double actualFahrenheit = TemperatureConverter.celsiusToFahrenheit(celsius);
        assertEquals(expectedFahrenheit, actualFahrenheit, DELTA);
    }

    @Test
    @DisplayName("Should handle fractional temperatures from Fahrenheit to Celsius")
    void fahrenheitToCelsius_fractionalFahrenheit_returnsCorrectCelsius() {
        double fahrenheit = 77.9;
        double expectedCelsius = 25.5;
        double actualCelsius = TemperatureConverter.fahrenheitToCelsius(fahrenheit);
        assertEquals(expectedCelsius, actualCelsius, DELTA);
    }
}

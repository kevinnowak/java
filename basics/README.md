# Java Basics Module

This module is dedicated to fundamental Java programming concepts. It covers basic data types, arithmetic operations, and introduces simple utility class design.

## Concepts Covered

*   **Primitive Data Types**: Introduction to `double` for floating-point numbers.
*   **Arithmetic Operations**: Basic mathematical calculations.
*   **Static Methods**: Using `static` keyword for utility functions.
*   **Unit Testing**: Demonstrates how to write and run unit tests using JUnit 5.

## Example: Temperature Converter

The `TemperatureConverter` class provides static methods to convert temperatures between Celsius and Fahrenheit.

### `TemperatureConverter.java`

This class contains two main methods:
*   `celsiusToFahrenheit(double celsius)`: Converts Celsius to Fahrenheit.
*   `fahrenheitToCelsius(double fahrenheit)`: Converts Fahrenheit to Celsius.

It also includes a `main` method to demonstrate its usage.

### Running the Example

To run the `main` method of `TemperatureConverter` (from within the Dev Container):

```bash
cd basics
mvn compile exec:java -Dexec.mainClass="com.github.kevinnowak.basics.temperature_converter.TemperatureConverter"
```

## Unit Tests

The `TemperatureConverterTest` class contains a suite of unit tests for the `TemperatureConverter` methods, ensuring their correctness.

### Running the Tests

To run all unit tests in this module (from within the Dev Container):

```bash
cd basics
mvn test
```

package com.github.kevinnowak.java.java_language_specification.interfaces.generic_interfaces;

// Single Bound: T must be a subclass of Number (or Number itself)
public interface MathOperations<T extends Number> {

    double sum(T a, T b);
}

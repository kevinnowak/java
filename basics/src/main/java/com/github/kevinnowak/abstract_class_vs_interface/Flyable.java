package com.github.kevinnowak.abstract_class_vs_interface;

interface Flyable {

    // Public static final constant (only option)
    int MAX_ALTITUDE = 40_000;

    // Abstract method (default)
    void fly();

    // Default method (Java 8+)
    default void land() {
        System.out.println("Landing...");
    }
}

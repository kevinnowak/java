package com.github.kevinnowak.java.reflection;

public class ReflectionExercise {

    static void main() {
        IO.println("=== Java Reflection API Exercise ===");

        demonstrateBasicReflection();

        IO.println("=== Exercise Complete ===");
    }

    private static void demonstrateBasicReflection() {
        IO.println("BASIC REFLECTION - Getting Class Information:");

        // Different ways to get Class object
        Class<SampleEmployee> clazz1 = SampleEmployee.class;
        var employee = new SampleEmployee("Alice", 1_001, 75_000);
        Class<?> clazz2 = employee.getClass();

        try {
            Class<?> clazz3 = Class.forName("com.github.kevinnowak.java.reflection.SampleEmployee");
            IO.println("Got class via employee.getClass(): " + clazz2.getSimpleName());
            IO.println("Got class via Class.forName(): " + clazz3.getSimpleName());
        } catch (ClassNotFoundException e) {
            IO.println("Class not found: " + e.getMessage());
        }
    }
}

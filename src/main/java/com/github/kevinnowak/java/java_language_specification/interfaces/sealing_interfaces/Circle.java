package com.github.kevinnowak.java.java_language_specification.interfaces.sealing_interfaces;

public final class Circle implements Shape {

    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}

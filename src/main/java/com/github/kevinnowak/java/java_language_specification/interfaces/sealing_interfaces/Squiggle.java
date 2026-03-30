package com.github.kevinnowak.java.java_language_specification.interfaces.sealing_interfaces;

public class Squiggle implements Freeform {

    @Override
    public double area() {
        return 0.0;
    }

    @Override
    public void drawCustomPath() {
        System.out.println("Drawing a squiggle...");
    }
}

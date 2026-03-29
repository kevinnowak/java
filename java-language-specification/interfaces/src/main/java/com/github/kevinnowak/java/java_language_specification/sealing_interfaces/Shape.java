package com.github.kevinnowak.java.java_language_specification.sealing_interfaces;

public sealed interface Shape permits Circle, Polygon, Freeform {

    double area();
}

package com.github.kevinnowak.sealing_interfaces;

public sealed interface Shape permits Circle, Polygon, Freeform {

    double area();
}

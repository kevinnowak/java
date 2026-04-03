package com.github.kevinnowak.java.java_language_specification.classes.record_classes;

record Point(double x, double y) {

    static Point ORIGIN = new Point(0, 0);

    static double distance(Point p, Point q) {
        return Math.hypot(p.x - q.x, p.y - q.y);
    }

    double distanceFromOrigin() {
        return Math.hypot(x, y);
    }
}

package com.github.kevinnowak.dynamic_method_dispatch;

public class Triangle extends Figure {

    Triangle(double a, double b) {
        super(a, b);
    }

    @Override
    double area() {
        System.out.println("Inside area for triangle");

        return (dim1 * dim2) / 2;
    }
}

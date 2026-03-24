package com.github.kevinnowak.dynamic_method_dispatch;

public class Rectangle extends Figure {


    Rectangle(double a, double b) {
        super(a, b);
    }

    @Override
    double area() {
        System.out.println("Inside area for rectangle");

        return dim1 * dim2;
    }
}

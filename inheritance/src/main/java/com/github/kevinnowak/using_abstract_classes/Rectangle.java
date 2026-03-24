package com.github.kevinnowak.using_abstract_classes;

class Rectangle extends Figure {

    Rectangle(double dim1, double dim2) {
        super(dim1, dim2);
    }

    @Override
    double area() {
        System.out.println("Inside area() for rectangles");

        return dim1 * dim2;
    }
}

package com.github.kevinnowak.using_abstract_classes;

class Triangle extends Figure {

    Triangle(double dim1, double dim2) {
        super(dim1, dim2);
    }

    @Override
    double area() {
        System.out.println("Inside area() for triangles");

        return (dim1 * dim2) / 2;
    }
}

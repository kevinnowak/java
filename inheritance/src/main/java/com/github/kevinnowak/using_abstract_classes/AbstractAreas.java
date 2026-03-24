package com.github.kevinnowak.using_abstract_classes;

public class AbstractAreas {

    public static void main(String[] args) {
        // Figure f = new Figure(10, 10); // -> not allowed
        Rectangle r = new Rectangle(9, 5);
        Triangle t = new Triangle(10, 8);
        Figure ref;

        ref = r;
        System.out.println(ref.area());

        ref = t;
        System.out.println(ref.area());
    }
}

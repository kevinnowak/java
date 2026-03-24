package com.github.kevinnowak.dynamic_method_dispatch;

public class FindAreas {

    public static void main(String[] args) {
        Figure f = new Figure(10, 10);
        Rectangle r = new Rectangle(9, 5);
        Triangle t = new Triangle(10, 8);
        Figure ref;

        ref = r;
        System.out.println("Area is " + ref.area());

        ref = t;
        System.out.println("Area is " + ref.area());

        ref = f;
        System.out.println("Area is " + ref.area());
    }
}

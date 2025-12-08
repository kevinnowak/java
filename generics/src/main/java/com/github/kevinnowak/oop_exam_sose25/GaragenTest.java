package com.github.kevinnowak.oop_exam_sose25;

class GaragenTest {

    public static void main(String[] args) {
        Garage<Auto> g1 = new Garage<Auto>();
        g1.einparken(new Auto());
        Auto auto = g1.ausparken();
    }
}

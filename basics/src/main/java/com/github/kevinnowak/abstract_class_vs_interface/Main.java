package com.github.kevinnowak.abstract_class_vs_interface;

class Main {

    public static void main(String[] args) {
        FlyingCar flyingCar = new FlyingCar("Toyota", 2025);
        flyingCar.start();
        flyingCar.fly();
        flyingCar.swim();
    }
}

package com.github.kevinnowak.abstract_class_vs_interface;

class FlyingCar extends Vehicle implements Flyable, Swimmable {

    FlyingCar(String brand, int year) {
        super(brand, year); // Abstract class constructor
    }

    @Override
    public void fly() {
        System.out.println("Flying at " + MAX_ALTITUDE + " ft");
    }

    @Override
    public void swim() {
        System.out.println("Swimming mode activated");
    }

    @Override
    void start() {
        System.out.println(brand + " engine started");
    }
}

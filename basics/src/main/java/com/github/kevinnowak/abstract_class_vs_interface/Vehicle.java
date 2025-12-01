package com.github.kevinnowak.abstract_class_vs_interface;

abstract class Vehicle {

    // Instance variable
    protected final String brand;
    private final int year;

    // Constructor
    Vehicle(String brand, int year) {
        this.brand = brand;
        this.year = year;
    }

    // Concrete method
    void displayInfo() {
        System.out.println(brand + " - " + year);
    }

    // Abstract method
    abstract void start();
}

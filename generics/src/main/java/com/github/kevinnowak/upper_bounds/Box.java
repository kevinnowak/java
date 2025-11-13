package com.github.kevinnowak.upper_bounds;

class Box<T extends Number> {

    private T data;

    Box(T data) {
        this.data = data;
    }

    public static <T extends Number> boolean isZero(T data) {
        return data.equals(0);
    }

    public static void main(String[] args) {
        Box<Integer> intBox = new Box<>(2); // Valid type argument
        Box<Double> doubleBox = new Box<>(2.5); // Valid type argument
//        Box<String> stringBox = new Box<>("Hello"); // Error

        System.out.println(isZero(1));
        System.out.println(isZero(0));
//        System.out.println(isZero("Hello"));
    }
}

package com.github.kevinnowak.java.collections.iterable;

public class CustomIterableExample {

    static void main() {
        Range range = new Range(1, 5);

        for (Integer number : range) {
            IO.print(number + " ");
        }
    }
}

package com.github.kevinnowak.varargs;

class Example {

    static void main(String... args) {
        int n = 1;
        IO.println("%d".formatted(n));
        IO.println("%d %s".formatted(n, "widgets"));
        // Becomes .formatted(new Object[] { Integer.valueOf(n), "widgets" }) -> it is even allowed to pass the array

        IO.println(max(3.1, 40.4, -5));
    }

    static double max(double... values) {
        double largest = Double.NEGATIVE_INFINITY;

        for (double v : values) {
            if (v > largest) {
                largest = v;
            }
        }

        return largest;
    }
}

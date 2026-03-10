package com.github.kevinnowak.ternary_operator;

class Ternary {

    public static void main(String[] args) {
        int i, k;

        i = 10;
        k = getAbsoluteValue(i);
        print(i, k);

        i = -10;
        k = getAbsoluteValue(i);
        print(i, k);
    }

    private static void print(int i, int k) {
        System.out.println("Absolute value of " + i + " is " + k);
    }

    private static int getAbsoluteValue(int i) {
        return i < 0 ? -i : i;
    }
}

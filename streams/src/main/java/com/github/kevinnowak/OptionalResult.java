package com.github.kevinnowak;

import java.util.Arrays;
import java.util.OptionalInt;

class OptionalResult {

    public static void main(String[] args) {
        int simple[] = {5, 12, 13, 10, 24, 26};

        OptionalInt anyInt = Arrays.stream(simple).findAny();
        System.out.println(anyInt.getAsInt());

        String[] folks = {"Clark", "Diana", "Bruce", "Dick", "Arthur"};
        System.out.println(Arrays.stream(folks).max((n1, n2) -> n1.compareTo(n2)));
//        System.out.println(Arrays.stream(folks).max(String::compareTo));
    }
}

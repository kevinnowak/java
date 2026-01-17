package com.github.kevinnowak;

import java.util.Arrays;

class DebuggingWithPeek {

    public static void main(String[] args) {
        String[] folks = {"Clark", "Diana", "Bruce", "Dick", "Arthur"};

        Arrays.stream(folks)
                .peek(n -> System.out.println("Original: " + n))
                .sorted()
                .forEach(System.out::println);
    }
}

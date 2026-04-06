package com.github.kevinnowak.java.java_api.function_types;

import java.util.function.BiFunction;

class BiFunctionExample {

    static void main() {
        BiFunction<String, String, Integer> comp = (first, second) -> first.length() - second.length();

    }
}

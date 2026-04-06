package com.github.kevinnowak.java.java_api.function_types;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

class FunctionExample {

    // Interface: Function<T, R>
    // Signature: R apply(T t)

    static void main() {
        String[] array = {"1", "2", "3", "4", "5"};
        Function<String[], List<String>> function = Arrays::asList;
        IO.println(function.apply(array));
    }
}

package com.github.kevinnowak.java.java_api.function_types;

import java.util.function.UnaryOperator;

class UnaryOperatorExample {

    // Interface: UnaryOperator<T>
    // Signature: T apply(T t)

    static void main() {
        UnaryOperator<String> unaryOperator = String::toUpperCase;
        IO.println(unaryOperator.apply("uppercase"));
    }
}
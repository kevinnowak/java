package com.github.kevinnowak.java.java_api.function_types;

import java.util.function.Consumer;

class ConsumerExample {

    // Interface: Consumer<T>
    // Signature: void accept(T t)

    static void main() {
        Consumer<String> consumer = System.out::println;
        consumer.accept("Hello world!");
    }
}

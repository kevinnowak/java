package com.github.kevinnowak.java.java_api.function_types;

import java.util.function.Predicate;

public class PredicateExample {

    // Interface: Predicate<T, U>
    // Signature: boolean test(T t, U u)

    static void main() {
        Predicate<String> predicate = String::isEmpty;
        IO.println(predicate.test("Not empty"));
        IO.println(predicate.test(""));
    }
}

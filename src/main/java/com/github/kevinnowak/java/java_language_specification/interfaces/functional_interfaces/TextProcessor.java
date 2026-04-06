package com.github.kevinnowak.java.java_language_specification.interfaces.functional_interfaces;

@FunctionalInterface
interface TextProcessor {

    String process(String text);

    default void printTwice(String text) {
        IO.println(text + " " + text);
    }
}

package com.github.kevinnowak.java.java_language_specification.lambda_expressions;

import java.awt.event.ActionListener;
import java.time.Instant;
import java.util.Comparator;

public class Example {

    static void main() {
        Comparator<String> comp1 = (first, second) -> first.length() - second.length();
        ActionListener listener1 = event -> IO.println(event.getWhen());
        ActionListener listener2 = _ -> IO.println("The actions occurred at " + Instant.now());
        Comparator<String> comp2 = (_, _) -> 0;
    }
}

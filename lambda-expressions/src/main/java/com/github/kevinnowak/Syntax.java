package com.github.kevinnowak;

import java.awt.event.ActionListener;
import java.time.Instant;
import java.util.Comparator;
import java.util.concurrent.Callable;

public class Syntax {

    static void main(String[] args) {
        Comparator<String> stringComparator1 = (String first, String second) -> first.length() - second.length();

        Comparator<String> stringComparator2 = (String first, String second) -> {
            if (first.length() < second.length()) {
                return -1;
            } else if (first.length() > second.length()) {
                return 1;
            } else {
                return 0;
            }
        };

        Callable<Integer> callable = () -> 1 + (int) (Math.random() * 6);

        Comparator<String> comp1 = (first, second) -> first.length() - second.length();

        ActionListener listener1 = event ->
                IO.println("The time is " + Instant.ofEpochMilli(event.getWhen()));

        ActionListener listener2 = _ -> IO.println("The action occurred at " + Instant.now());
        Comparator<String> comp2 = (_, _) -> 0;
    }
}
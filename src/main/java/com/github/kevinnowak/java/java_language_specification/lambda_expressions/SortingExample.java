package com.github.kevinnowak.java.java_language_specification.lambda_expressions;

import javax.swing.*;
import java.time.Instant;
import java.util.Arrays;

class SortingExample {

    static void main() {
        var planets = new String[]{
                "Mercury",
                "Venus",
                "Earth",
                "Mars",
                "Jupiter",
                "Saturn",
                "Uranus",
                "Neptune"
        };

        IO.println(Arrays.toString(planets));
        IO.println("Sorted in dictionary order:");
        Arrays.sort(planets);
        IO.println(Arrays.toString(planets));
        IO.println("Sorted by length:");
        Arrays.sort(planets, (first, second) -> first.length() - second.length());
        IO.println(Arrays.toString(planets));

        var timer = new Timer(1_000, _ -> IO.println("The time is " + Instant.now()));
        timer.start();

        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
    }
}

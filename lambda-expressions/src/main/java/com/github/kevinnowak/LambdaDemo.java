package com.github.kevinnowak;

import javax.swing.*;
import java.lang.reflect.Array;
import java.time.Instant;
import java.util.Arrays;

class LambdaDemo {

    void main() {
        var planets = new String[]{"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune"};
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

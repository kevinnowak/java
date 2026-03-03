package com.github.kevinnowak.primitive_types;

public class Light {

    public static void main(String[] args) {
        int lightspeed = 186_000;
        long days = 1_000;
        long seconds = days * 24 * 60 * 60;
        long distance = lightspeed * seconds;

        System.out.print("In " + days);
        System.out.print(" days light will travel about ");
        System.out.println(distance + " miles.");
    }
}

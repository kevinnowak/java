package com.github.kevinnowak.primitive_types;

public class AllPrimitiveTypes {

    public static void main(String[] args) {
        // Integer numbers
        byte b = 125; // 8 bits
        short s = 32_147; // 16 bits
        int i = 2_600_000; // 32 bits
        long l = 9_234_231_563_142_842L; // 64 bits

        // Floating-point numbers
        float f = 1.0F; // 32 bits
        double d = 1.0; //
        double scientificNotation = 6.022E23;

        // Characters
        char c = 'e'; // 16 bits, covers all Unicode

        // Boolean
        boolean bool = true;

        // Other bases
        int octal = 0137;
        int hexadecimal = 0xABC;
        int binary = 0b1010;
    }
}

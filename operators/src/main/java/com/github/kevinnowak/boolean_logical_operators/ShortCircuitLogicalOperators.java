package com.github.kevinnowak.boolean_logical_operators;

class ShortCircuitLogicalOperators {

    public static void main(String[] args) {
        // && and || -> right-hand operand will not be evaluated
        boolean b = false;
        int i = 0;

        if (b && 10 / i > 0) {
            // Fine
        }

        if (b & 10 / i > 0) {
            // Throws an ArithmeticException
        }
    }
}

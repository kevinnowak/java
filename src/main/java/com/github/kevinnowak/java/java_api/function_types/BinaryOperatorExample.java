package com.github.kevinnowak.java.java_api.function_types;

import java.math.BigInteger;
import java.util.function.BinaryOperator;

class BinaryOperatorExample {

    // Interface: BinaryOperator<T>
    // Signature: T apply(T t1, T t2)

    static void main() {
        BinaryOperator<BigInteger> binaryOperator = BigInteger::add;
        IO.println(binaryOperator.apply(BigInteger.valueOf(10), BigInteger.valueOf(5)));
    }
}

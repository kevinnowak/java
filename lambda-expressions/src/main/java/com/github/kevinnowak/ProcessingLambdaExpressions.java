package com.github.kevinnowak;

import java.util.function.IntConsumer;

class ProcessingLambdaExpressions {

    static void main() {
        repeat(10, (i) -> IO.println("Countdown: " + (9 - i)));
    }

    static void repeat(int n, IntConsumer action) {
        for (int i = 0; i < n; i++) {
            action.accept(i);
        }
    }
}

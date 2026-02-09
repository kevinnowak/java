package com.github.kevinnowak.synchronized_keyword;

class StaticCounter {

    private static int staticCount = 0;

    // Locks the StaticCounter.class object
    public static synchronized void incrementStatic() {
        staticCount++;
    }

    // Above is equivalent to this
    public static void incrementStaticSimilar() {
        synchronized (StaticCounter.class) {
            staticCount++;
        }
    }
}

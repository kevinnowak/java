package com.github.kevinnowak.synchronized_keyword;

class NonThreadSafeCounter {

    private int count = 0;

    void increment() {
        count++; // Not thread-safe
    }

    int getCount() {
        return count;
    }
}

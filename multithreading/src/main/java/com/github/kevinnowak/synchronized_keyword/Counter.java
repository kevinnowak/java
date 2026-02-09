package com.github.kevinnowak.synchronized_keyword;

class Counter {

    private int count = 0;

    // The synchronized keyword here locks the entire object instance
    synchronized void increment() {
        count++;
    }

    // The above is equivalent to this
    void incrementSimilar() {
        synchronized (this) {
            count++;
        }
    }

    int getCount() {
        return count;
    }
}

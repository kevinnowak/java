package com.github.kevinnowak.synchronized_keyword;

class FineGrainedCounter {

    private int count = 0;
    private final Object lock = new Object(); // A dedicated lock object

    void increment() {
        // Do some non-thread-safe work here (like logging)
        System.out.println(Thread.currentThread().getName() + " is working...");

        synchronized (lock) {
            // Only this critical section is thread-safe
            count++;
        }
    }

    int getCount() {
        return count;
    }
}

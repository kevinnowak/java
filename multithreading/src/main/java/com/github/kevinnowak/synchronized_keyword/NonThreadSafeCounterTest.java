package com.github.kevinnowak.synchronized_keyword;

class NonThreadSafeCounterTest {

    public static void main(String[] args) throws InterruptedException {
        NonThreadSafeCounter counter = new NonThreadSafeCounter();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1_000_000; i++) {
                counter.increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1_000_000; i++) {
                counter.increment();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Count: " + counter.getCount());
    }
}

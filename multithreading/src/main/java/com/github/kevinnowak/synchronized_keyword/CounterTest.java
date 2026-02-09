package com.github.kevinnowak.synchronized_keyword;

class CounterTest {

    public static void main(String[] args) throws InterruptedException {
        FineGrainedCounter counter = new FineGrainedCounter();

        // Create two threads that both increment 1000 times
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1_000; i++) {
                counter.increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1_000; i++) {
                counter.increment();
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("Final count: " + counter.getCount()); // Should be exactly 2000
    }
}

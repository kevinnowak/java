package com.github.kevinnowak.jakob_jenkov_examples;

class ThreadExample9 {

    public static void main(String[] args) {
        Runnable runnable = () -> {
            while (true) {
                sleep(1_000);
                System.out.println("Running");
            }
        };

        Thread thread = new Thread(runnable);
        thread.setDaemon(true);
        thread.start();
        sleep(3_100);
    }

    static void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}

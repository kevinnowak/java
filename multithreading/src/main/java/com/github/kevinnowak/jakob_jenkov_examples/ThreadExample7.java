package com.github.kevinnowak.jakob_jenkov_examples;

class ThreadExample7 {

    public static void main(String[] args) {
        Runnable runnable = () -> {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " running...");

            try {
                Thread.sleep(2_000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }

            System.out.println(threadName + " finished...");
        };

        Thread thread = new Thread(runnable, "RunnableThread");
        thread.start();
    }
}

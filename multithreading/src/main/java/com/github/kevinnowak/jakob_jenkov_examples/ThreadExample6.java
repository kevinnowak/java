package com.github.kevinnowak.jakob_jenkov_examples;

class ThreadExample6 {

    public static void main(String[] args) {
        System.out.println("Thread running in the main method: " + Thread.currentThread().getName());

        Runnable runnable = () -> {
            System.out.println("Thread running in the runnable: " + Thread.currentThread().getName());
        };

        Thread thread1 = new Thread(runnable, "RunnableThread1");
        thread1.start();

        Thread thread2 = new Thread(runnable, "RunnableThread2");
        thread2.start();
    }
}

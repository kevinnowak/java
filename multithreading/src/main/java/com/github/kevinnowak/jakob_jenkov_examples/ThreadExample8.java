package com.github.kevinnowak.jakob_jenkov_examples;

class ThreadExample8 {

    static class StoppableRunnable implements Runnable {

        private boolean stopRequested = false;

        synchronized void requestStop() {
            this.stopRequested = true;
        }

        synchronized boolean isStopRequested() {
            return this.stopRequested;
        }

        private void sleep(long ms) {
            try {
                Thread.sleep(ms);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }

        @Override
        public void run() {
            System.out.println("StoppableRunnable running");

            while (!isStopRequested()) {
                sleep(1_000);
                System.out.println("...");
            }

            System.out.println("StoppableRunnable stopped");
        }
    }

    public static void main(String[] args) {
        StoppableRunnable stoppableRunnable = new StoppableRunnable();
        Thread thread = new Thread(stoppableRunnable, "stoppableRunnableThread");
        thread.start();

        try {
            Thread.sleep(5_000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Requesting stop");
        stoppableRunnable.requestStop();
        System.out.println("Stop requested");
    }
}

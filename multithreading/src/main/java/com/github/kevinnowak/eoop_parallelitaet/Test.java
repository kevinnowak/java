package com.github.kevinnowak.eoop_parallelitaet;

class Test {

    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().getState());
        AnhaltbarerThread at = new AnhaltbarerThread();
        at.start();
        System.out.println("Gestartet");
        Thread.sleep(1);
        at.interrupt();
        at.anhalten();
    }
}

package com.github.kevinnowak.eoop_parallelitaet;

import java.time.LocalDateTime;

class AnhaltbarerThread extends Thread {

    private volatile boolean anhalten = false;

    @Override
    public void run() {
        while (!anhalten) {
            System.out.println(Thread.currentThread().getName());
            System.out.println(Thread.currentThread().getState());
        }

        System.out.println("Beendet");
    }

    void anhalten() {
        anhalten = true;
    }
}

package com.github.kevinnowak.eoop_parallelitaet.gemeinsame_ressourcen;

public class Konto {

    private int saldo;
    private int i = 0;

    public Konto(int saldo) {
        this.saldo = saldo;
    }

    public void einzahlen(int betrag) {
        int tmp = saldo + betrag;
        if (i == 0) {
            System.out.println(Thread.currentThread().getName() + " is yielding soon...");
            i++;
            Thread.yield();
        }

        saldo = tmp;
    }

    public void printSaldo() {
        System.out.println(String.valueOf(saldo));
    }
}

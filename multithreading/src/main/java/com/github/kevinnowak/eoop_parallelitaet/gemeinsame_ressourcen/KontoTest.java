package com.github.kevinnowak.eoop_parallelitaet.gemeinsame_ressourcen;

class KontoTest {

    public static void main(String[] args) throws InterruptedException {
        Konto konto = new Konto(1_000);
        Thread a = new Einzahler(konto, 2_000);
        Thread b = new Einzahler(konto, 4_000);
        a.start();
        b.start();
        a.join();
        b.join();
        konto.printSaldo();
    }
}

package com.github.kevinnowak.oop_exam_sose25;

class Garage<T extends Fahrzeug> {

    private T fahrzeug;

    void einparken(T fahrzeug) {
        this.fahrzeug = fahrzeug;
    }

    T ausparken() {
        T ret = fahrzeug;
        fahrzeug = null;

        return ret;
    }
}

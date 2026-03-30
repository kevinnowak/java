package com.github.kevinnowak.java.java_language_specification.classes.enum_classes.enum_body_declarations;

enum Coin {

    PENNY(1),
    NICKEL(5),
    DIME(10),
    QUARTER(25);

    Coin(int value) {
        this.value = value;
    }

    private final int value;

    public int value() {
        return value;
    }
}

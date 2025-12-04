package com.github.kevinnowak;

record SomeRecordImplementingAnInterface() implements Moveable {

    @Override
    public void move(double x, double y) {
    }
}

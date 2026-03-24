package com.github.kevinnowak.using_abstract_classes;

abstract class A {

    abstract void callMe();

    void callMeToo() {
        System.out.println("This is a concrete method");
    }
}

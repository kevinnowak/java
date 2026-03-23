package com.github.kevinnowak.dynamic_method_dispatch;

public class B extends A {

    @Override
    void callMe() {
        System.out.println("Inside B's callMe method");
    }
}

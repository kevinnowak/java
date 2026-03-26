package com.github.kevinnowak.p1;

class Derived extends Protection {

    Derived() {
        System.out.println("derived constructor");
        System.out.println("n = " + nDefault);
//        System.out.println("nPrivate = " + nPrivate);
        System.out.println("nProtected = " + nProtected);
        System.out.println("nPublic = " + nPublic);
    }
}

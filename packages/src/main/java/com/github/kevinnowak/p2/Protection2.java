package com.github.kevinnowak.p2;

class Protection2 extends com.github.kevinnowak.p1.Protection {

    Protection2() {
        System.out.println("derived other package constructor");
//        System.out.println("n = " + nDefault);
//        System.out.println("nPrivate = " + nPrivate);
        System.out.println("nProtected = " + nProtected);
        System.out.println("nPublic = " + nPublic);
    }
}

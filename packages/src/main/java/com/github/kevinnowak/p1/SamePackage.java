package com.github.kevinnowak.p1;

class SamePackage {

    SamePackage() {
        Protection p = new Protection();
        System.out.println("same package constructor");
        System.out.println("n = " + p.nDefault);
//        System.out.println("nPrivate = " + p.nPrivate);
        System.out.println("nProtected = " + p.nProtected);
        System.out.println("nPublic = " + p.nPublic);
        ;
    }
}

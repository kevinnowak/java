package com.github.kevinnowak.p2;

import com.github.kevinnowak.p1.Protection;

class OtherPackage {

    OtherPackage() {
        Protection p = new Protection();
        System.out.println("other package constructor");

//        System.out.println("n = " + p.nDefault);
//        System.out.println("nPrivate = " + nPrivate);
//        System.out.println("nProtected = " + p.nProtected);
        System.out.println("nPublic = " + p.nPublic);
    }
}

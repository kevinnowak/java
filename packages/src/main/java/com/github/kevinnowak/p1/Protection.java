package com.github.kevinnowak.p1;

public class Protection {

    int nDefault = 1;
    private int nPrivate = 2;
    protected int nProtected = 3;
    public int nPublic = 4;

    public Protection() {
        System.out.println("base constructor");
        System.out.println("n = " + nDefault);
        System.out.println("nPrivate = " + nPrivate);
        System.out.println("nProtected = " + nProtected);
        System.out.println("nPublic = " + nPublic);
    }
}

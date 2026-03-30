package com.github.kevinnowak.java.java_language_specification.interfaces.superinterfaces_and_subinterfaces;

class iPhone implements Smartphone {

    @Override
    public void installApp() {
        System.out.println("Installing app...");
    }

    @Override
    public void takePhoto() {
        System.out.println("Taking a photo...");
    }

    @Override
    public void makeCall() {
        System.out.println("Making a call...");
    }
}

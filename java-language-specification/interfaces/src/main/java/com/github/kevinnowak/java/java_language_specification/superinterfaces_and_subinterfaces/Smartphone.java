package com.github.kevinnowak.java.java_language_specification.superinterfaces_and_subinterfaces;

// Camera and Phone are the direct superinterfaces
interface Smartphone extends Camera, Phone {

    void installApp();
}

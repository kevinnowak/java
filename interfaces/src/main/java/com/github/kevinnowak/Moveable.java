package com.github.kevinnowak;

public interface Moveable {
    int SOME_STATIC_FINAL_CONSTANT = 1;

    void move(double x, double y);
    private void somePrivateMethod() {}
    private static void somePrivateAndStaticMethod() {}
    default void someDefaultMethod() {}
}

package com.github.kevinnowak;

public interface Person {

    default String getName() {
        return "";
    }
}

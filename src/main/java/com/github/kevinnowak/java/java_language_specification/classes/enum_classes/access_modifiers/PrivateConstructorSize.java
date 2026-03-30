package com.github.kevinnowak.java.java_language_specification.classes.enum_classes.access_modifiers;

public enum PrivateConstructorSize {
    SMALL(1),
    MEDIUM(2),
    LARGE(3);

    private final int value;

    // This constructor is implicitly private
    // Trying to make it public will cause a compiler error
    PrivateConstructorSize(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

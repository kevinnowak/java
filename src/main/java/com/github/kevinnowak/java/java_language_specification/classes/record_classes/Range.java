package com.github.kevinnowak.java.java_language_specification.classes.record_classes;

record Range(int from, int to) {

    // Compact form, validating parameters
    Range {
        if (from > to) throw new IllegalArgumentException();
    }


}

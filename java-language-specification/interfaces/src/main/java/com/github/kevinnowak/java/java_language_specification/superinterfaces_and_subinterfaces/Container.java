package com.github.kevinnowak.java.java_language_specification.superinterfaces_and_subinterfaces;

interface Container<T> {

    T getItem();
}

interface StringContainer extends Container<String> {
}

interface GenericContainer<E> extends Container<E> {
}

// Compile-time error: wildcard (?) not allowed here
//interface UnknownContainer extends Container<?> {
//}

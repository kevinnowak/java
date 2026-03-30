package com.github.kevinnowak.java.java_language_specification.interfaces.generic_interfaces;

// A generic interface with a TypeParameterList (multiple parameters)
public interface BiMapper<K, V> {

    V map(K input);
}

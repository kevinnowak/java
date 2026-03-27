package com.github.kevinnowak.generic_interfaces;

// A generic interface with a TypeParameterList (multiple parameters)
public interface BiMapper<K, V> {

    V map(K input);
}

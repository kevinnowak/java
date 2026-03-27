package com.github.kevinnowak.generic_interfaces;

// A generic interface with a single type parameter 'T'
public interface Repository<T> {

    void save(T item);

    T findById(int id);
}

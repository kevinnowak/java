package com.github.kevinnowak.java.java_language_specification.interfaces.generic_interfaces;

// Additional Bounds: T must be a Number AND it must implement Comparable
// Note: You can only have one class in the bound, but multiple interface using '&'
public interface SortedNumberStore<T extends Number & Comparable<T>> {

    void addAndSort(T item);
}

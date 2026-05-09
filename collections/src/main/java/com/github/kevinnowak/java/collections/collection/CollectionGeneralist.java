package com.github.kevinnowak.java.collections.collection;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionGeneralist {

    static void main() {
        Collection<String> items = new ArrayList<>();

        items.add("Java");
        items.add("Python");
        items.add("C++");

        printCollection(items);
    }

    private static void printCollection(Collection<String> collection) {
        IO.println("Size: " + collection.size());

        for (String s : collection) {
            IO.print(s + " ");
        }

        IO.println("\n---");
    }
}

package com.github.kevinnowak.java.collections.collection;

import java.util.*;

public class CollectionMethods {

    static void main() {
        Collection<String> c = new ArrayList<>();

        // boolean add(E e)
        c.add("John");

        // boolean addAll(Collection<? extends E> c)
        c.addAll(Arrays.asList("Mike", "Steve"));

        IO.println("After adding: " + c);

        // boolean contains(Object o)
        if (!c.contains("Peter")) {
            IO.println("Does not contain Peter");
        }

        if (c.contains("Steve")) {
            IO.println("Contains Steve");
        }

        // boolean containsAll(Collection<? extends E> c)
        if (c.containsAll(Arrays.asList("John", "Steve", "Mike"))) {
            IO.println("Contains John, Steve and Mike");
        }

        if (c.containsAll(Arrays.asList("John", "George"))) {
            IO.println("Contains John and George");
        }

        // void clear()
        c.clear();

        IO.println("After clearing: " + c);
    }
}

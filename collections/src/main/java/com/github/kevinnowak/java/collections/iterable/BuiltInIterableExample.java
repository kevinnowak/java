package com.github.kevinnowak.java.collections.iterable;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class BuiltInIterableExample {

    static void main() {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

        // Enhanced For-Loop (requires Iterable)
        for (String name : names) {
            IO.println(name);
        }

        // Using the Iterator explicitly
        Iterator<String> iterator = names.iterator();

        while (iterator.hasNext()) {
            IO.println(iterator.next());
        }

        // Using the default forEach method (Java 8+)
        names.forEach(IO::println);
    }
}

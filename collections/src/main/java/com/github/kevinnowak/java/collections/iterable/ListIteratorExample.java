package com.github.kevinnowak.java.collections.iterable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class ListIteratorExample {

    static void main() {
        List<String> levels = new ArrayList<>(Arrays.asList("Level 1", "Level 2", "Level 3"));

        // Obtain the list iterator
        ListIterator<String> listIterator = levels.listIterator();

        IO.println("Forward traversal:");

        while (listIterator.hasNext()) {
            String current = listIterator.next();
            IO.println("\tIndex " + listIterator.nextIndex() + ": " + current);

            // Replace a value while iterating
            if (current.equals("Level 2")) {
                listIterator.set("Level 2 - COMPLETED");
            }
        }

        IO.println("\nBackward traversal:");

        while (listIterator.hasPrevious()) {
            IO.println("\tReturning to: " + listIterator.previous());
        }
    }
}

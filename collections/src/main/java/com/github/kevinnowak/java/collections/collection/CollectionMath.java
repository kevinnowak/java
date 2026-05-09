package com.github.kevinnowak.java.collections.collection;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

public class CollectionMath {

    static void main() {
        Collection<Integer> setA = new HashSet<>(Arrays.asList(1, 2, 3, 4));
        Collection<Integer> setB = new HashSet<>(Arrays.asList(3, 4, 5, 6));

        // Union (add all from B to A)
        Collection<Integer> union = new HashSet<>(setA);
        union.addAll(setB);
        IO.println("Union: " + union);

        // Intersection (keep only what is in both)
        Collection<Integer> intersection = new HashSet<>(setA);
        intersection.retainAll(setB);
        IO.println("Intersection: " + intersection);

        // Difference (remove everything found in B from A)
        Collection<Integer> difference = new HashSet<>(setA);
        difference.removeAll(setB);
        IO.println("Difference: " + difference);
    }
}

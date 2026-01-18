package com.github.kevinnowak.loy;

import java.util.Arrays;
import java.util.Comparator;

class Sorting {

    public static void main(String[] args) {
        String[] folks = {"Clark", "Diana", "Bruce", "Dick", "Arthur"};

        Arrays.stream(folks).sorted().forEach(System.out::println);
        Arrays.stream(folks).sorted((a, b) -> b.compareTo(a)).forEach(System.out::println);

        int simple[] = {5, 12, 13, 10, 24, 26};
        Arrays.stream(simple).sorted().forEach(System.out::println); // -> no sorted(Comparator<T>) for IntStream
        // boxed() helps with that -> transforms to Stream<Integer>
        Arrays.stream(simple).boxed().sorted(Comparator.reverseOrder()).forEach(System.out::println);
    }
}

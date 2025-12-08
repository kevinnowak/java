package com.github.kevinnowak;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class LengthComparatorTest {

    public static void main(String[] args) {
        String[] friends = {"Peter", "Alexander", "leonard", "lando", "Jim"};
        System.out.println(Arrays.toString(friends));
        Arrays.sort(friends, new LengthComparator());
        System.out.println(Arrays.toString(friends));
        Arrays.sort(friends, String.CASE_INSENSITIVE_ORDER);
        System.out.println(Arrays.toString(friends));
        Arrays.sort(friends);
        System.out.println(Arrays.toString(friends));
        Collections.shuffle(Arrays.asList(friends));
        System.out.println(Arrays.toString(friends));
    }
}

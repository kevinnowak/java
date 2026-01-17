package com.github.kevinnowak;

import java.util.Arrays;

class FindingSomething {

    public static void main(String[] args) {
        int simple[] = {5, 12, 13, 10, 24, 26};

       // anyMatch()
        System.out.println(Arrays.stream(simple).anyMatch(x -> x < 10));

        // allMatch()
        System.out.println(Arrays.stream(simple).allMatch(x -> x < 10));

        // noneMatch()
        System.out.println(Arrays.stream(simple).noneMatch(x -> x < 0));
    }
}

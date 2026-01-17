package com.github.kevinnowak;

import java.util.Arrays;

class FindEverything {

    public static void main(String[] args) {
        String[] folks = {"Clark", "Diana", "Bruce", "Dick", "Arthur"};

        Arrays.stream(folks).forEach(name -> System.out.println(name));
//        Arrays.stream(folks).forEach(System.out::println);
    }
}

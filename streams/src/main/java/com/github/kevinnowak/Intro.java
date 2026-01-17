package com.github.kevinnowak;

import java.util.Arrays;
import java.util.stream.IntStream;

class Intro {

    public static void main(String[] args) {
        int simple[] = {5, 12, 13, 10, 24, 26};

        System.out.println(Arrays.stream(simple).count());
        System.out.println(Arrays.stream(simple).sum());

        IntStream s1 = Arrays.stream(simple);
        s1.count();
//        s1.sum(); -> Won't work as the stream is already closed

        IntStream s2 = IntStream.builder().add(5).add(10).add(1).build();
        System.out.println(s2.sum());
    }
}

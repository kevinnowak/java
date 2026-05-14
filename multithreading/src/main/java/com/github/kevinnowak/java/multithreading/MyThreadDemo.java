package com.github.kevinnowak.java.multithreading;

import java.util.List;
import java.util.stream.Stream;

public class MyThreadDemo {

    static void main() {
        List<MyThread> threads = Stream.iterate(0, n -> n + 1)
                .map(MyThread::new)
                .limit(10)
                .toList();

        threads.forEach(MyThread::start);
    }
}

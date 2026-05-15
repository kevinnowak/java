package com.github.kevinnowak.java.multithreading;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Stream;

public class ExecutorsDemo {

    static void main() {
        List<MyRunnable> runnables = Stream.iterate(0, n -> n + 1)
                .map(MyRunnable::new)
                .limit(10)
                .toList();

        try (ExecutorService service = Executors.newCachedThreadPool()) {
            runnables.forEach(service::execute);
        }
    }
}

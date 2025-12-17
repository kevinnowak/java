package com.github.kevinnowak;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Objects;

class MethodReferences {

    void main() {
        var timer1 = new Timer(1_000, event -> IO.println(event));
        var timer2 = new Timer(1_000, IO::println);

        Runnable task = IO::println;
        task.run();

        ArrayList<Integer> list = new ArrayList<>();
        list.add(null);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(null);
        list.removeIf((object) -> { return object == null;});
        list.removeIf(Objects::isNull);
    }
}

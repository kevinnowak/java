package com.github.kevinnowak;

import javax.swing.*;
import java.awt.event.ActionListener;

class Greeter {

    private String text;

    void delayMessage(int delay) {
        ActionListener listener = event -> IO.println(text);
        new Timer(delay, listener).start();
    }

    void greet() {
        text = "Hello";
        delayMessage(1_000);
        text = "Goodbye";
        delayMessage(2_000);
    }

    static void main() {
        Greeter greeter = new Greeter();
        greeter.greet();
    }
}

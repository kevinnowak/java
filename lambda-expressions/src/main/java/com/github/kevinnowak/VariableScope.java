package com.github.kevinnowak;

import javax.swing.*;
import java.awt.event.ActionListener;

class VariableScope {

    void main() {
      repeatMessage("Hello", 1_000);
    }

    static void repeatMessage(String text, int delay) {
        ActionListener listener = event -> {
            IO.println(text);
        };

        new Timer(delay, listener).start();
    }
}

package com.github.kevinnowak.java.serialization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.UncheckedIOException;

public class SerializationDemo {

    static void main() {
        User user = new User("Kevin", "<PASSWORD>");
        IO.println(user);

        try (ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream("user.bin")
        )) {
            out.writeObject(user);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}

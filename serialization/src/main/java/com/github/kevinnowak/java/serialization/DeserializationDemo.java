package com.github.kevinnowak.java.serialization;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializationDemo {

    static void main() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("user.bin"))){
            if (in.readObject() instanceof User user) {
                IO.println(user);;
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

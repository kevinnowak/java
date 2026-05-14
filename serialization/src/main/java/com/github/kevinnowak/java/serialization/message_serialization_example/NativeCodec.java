package com.github.kevinnowak.java.serialization.message_serialization_example;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class NativeCodec implements MessageCodec {

    @Override
    public String name() {
        return "Native Codec";
    }

    @Override
    public byte[] encode(Message message) {
        try (var baos = new ByteArrayOutputStream(); var oos = new ObjectOutputStream(baos)) {
            oos.writeObject(message);
            oos.flush();

            return baos.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Message decode(byte[] bytes) {
        return null;
    }
}

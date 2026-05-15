package com.github.kevinnowak.java.serialization.message_serialization_example;

import java.io.*;

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
        try (var bais = new ByteArrayInputStream(bytes); var ois = new ObjectInputStream(bais)) {
            return (Message) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

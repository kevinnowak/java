package com.github.kevinnowak.java.serialization.message_serialization_example;

public interface MessageCodec {

    String name();
    byte[] encode(Message message);
    Message decode(byte[] bytes);
}

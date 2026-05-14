package com.github.kevinnowak.java.serialization.message_serialization_example;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Main {

    static void main() {
        Message message = new Message(
                UUID.randomUUID(),
                Instant.now(),
                "Bob",
                "Hello, world!",
                10
        );

        IO.println(message);

        MessageCodec nativeCodec = new NativeCodec();
        var nativeBytes = nativeCodec.encode(message);

        MessageCodec jsonCodec = new JsonCodec();
        var jsonBytes = jsonCodec.encode(message);

        IO.println(nativeCodec.name() + " length: " + nativeBytes.length);
        IO.println(jsonCodec.name() + " length: " + jsonBytes.length);
    }

    static List<Message> generateMessages(int count) {
        List<Message> messages = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            Message message = new Message(
                    UUID.randomUUID(),
                    Instant.now(),
                    "Bob",
                    "Hello, world!",
                    10
            );

            messages.add(message);
        }

        return messages;
    }
}

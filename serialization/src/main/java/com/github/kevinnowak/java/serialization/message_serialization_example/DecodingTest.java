package com.github.kevinnowak.java.serialization.message_serialization_example;

import java.util.List;
import java.util.UUID;

// From bytes back to objects
public class DecodingTest {

    static void main() {
        var codecs = List.of(new JsonCodec(), new NativeCodec());

        for (MessageCodec codec : codecs) {
            IO.println("Testing " + codec.name());

            var message = new Message(
                    UUID.randomUUID(),
                    System.currentTimeMillis(),
                    "Alice",
                    "Hello, world!",
                    1
            );

            IO.println(message);

            var bytes = codec.encode(message);
            var decodedMessage = codec.decode(bytes);

            IO.println(decodedMessage);
        }
    }
}

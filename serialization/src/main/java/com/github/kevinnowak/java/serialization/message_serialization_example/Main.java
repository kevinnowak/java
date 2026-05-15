package com.github.kevinnowak.java.serialization.message_serialization_example;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;

public class Main {

    static void main() {

        var messages = generateMessages(1_000);
        MessageCodec nativeCodec = new NativeCodec();
        MessageCodec jsonCodec = new JsonCodec();
        List<MessageCodec> codecs = List.of(nativeCodec, jsonCodec);


        codecs.forEach(messageCodec -> {
            long start = System.nanoTime();
            var blobs = new ArrayList<byte[]>();
            messages.forEach(message -> blobs.add(messageCodec.encode(message)));

            long totalBytes = blobs.stream()
                    .mapToInt(blob -> blob.length)
                    .sum();

            long end = System.nanoTime();
            IO.println(messageCodec.name() + ": " + (end - start) / 1_000_000);
            IO.println("Total bytes: " + totalBytes);
        });
    }

    static List<Message> generateMessages(int count) {
        return IntStream.range(0, count)
                .mapToObj(_ -> new Message(
                    UUID.randomUUID(),
                    Instant.now(),
                    "Bob",
                    "Hello, world!",
                    10))
                .toList();
    }
}

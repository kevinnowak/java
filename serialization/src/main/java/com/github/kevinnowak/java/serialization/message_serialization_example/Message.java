package com.github.kevinnowak.java.serialization.message_serialization_example;

import java.io.Serializable;
import java.util.UUID;

public record Message(
        UUID id,
        long timestamp,
        String sender,
        String content,
        int priority
) implements Serializable {
}

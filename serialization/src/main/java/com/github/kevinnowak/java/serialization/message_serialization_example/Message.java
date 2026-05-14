package com.github.kevinnowak.java.serialization.message_serialization_example;

import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

public record Message (
        UUID id,
        Instant timestamp,
        String sender,
        String content,
        int priority
) implements Serializable {
}

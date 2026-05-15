package com.github.kevinnowak.java.serialization.message_serialization_example;

import java.time.Duration;
import java.time.Instant;

public class MessageValidator {

    private static final Duration MAX_FUTURE_TOLERANCE = Duration.ofMinutes(5);
    private static final Duration MAX_AGE = Duration.ofDays(365);

    public static void validate(Message message) {
        if (message == null) {
            throw new IllegalArgumentException("Message cannot be null");
        }

        Instant now = Instant.now();

        if (message.timestamp() < now.minus(MAX_AGE).toEpochMilli()) {
            throw new IllegalArgumentException("Message timestamp is too old");
        }

        if (message.timestamp() > now.plus(MAX_FUTURE_TOLERANCE).toEpochMilli()) {
            throw new IllegalArgumentException("Message timestamp is in the future");
        }

        if (message.priority() < 0 || message.priority() > 5) {
            throw new IllegalArgumentException("Invalid priority");
        }
    }
}

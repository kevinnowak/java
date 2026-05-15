package com.github.kevinnowak.java.serialization.message_serialization_example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JsonCodec implements MessageCodec {

    private final ObjectMapper objectMapper = new ObjectMapper();

    public JsonCodec() {
        objectMapper.findAndRegisterModules();
    }

    @Override
    public String name() {
        return "JSON Codec";
    }

    @Override
    public byte[] encode(Message message) {
        try {
            return objectMapper.writeValueAsBytes(message);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Message decode(byte[] bytes) {
        try {
            return objectMapper.readValue(bytes, Message.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

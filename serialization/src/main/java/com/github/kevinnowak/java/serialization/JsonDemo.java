package com.github.kevinnowak.java.serialization;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class JsonDemo {

    static void main() {
        User user1 = new User("Kevin", "test123");
        User user2 = new User("Steve", "test123");

        IO.println(user1);
        IO.println(user2);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);

        try {
            String jsonOutput = objectMapper.writeValueAsString(user1);
            IO.println(jsonOutput);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}

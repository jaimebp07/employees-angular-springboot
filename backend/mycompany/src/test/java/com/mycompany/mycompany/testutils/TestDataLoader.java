package com.mycompany.mycompany.testutils;

import java.io.InputStream;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

public class TestDataLoader {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static <T> T loadJson(String path, Class<T> clazz) throws Exception {
        InputStream inputStream = getResourceAsStream(path);
        return objectMapper.readValue(inputStream, clazz);
    }

    public static <T> T loadJson(String path, TypeReference<T> typeReference) throws Exception {
        InputStream inputStream = getResourceAsStream(path);
        return objectMapper.readValue(inputStream, typeReference);
    }

    private static InputStream getResourceAsStream(String path) throws Exception {
        InputStream inputStream = TestDataLoader.class.getClassLoader().getResourceAsStream(path);
        if (inputStream == null) {
            throw new IllegalArgumentException("No se encontró el archivo: " + path);
        }
        return inputStream;
    }
}

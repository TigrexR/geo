package com.tigrex.geo.utils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author linus
 */
public class JacksonUtils {

    private static final ThreadLocal<ObjectMapper> JACKSON_THREAD_LOCAL = ThreadLocal.withInitial(() -> {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return objectMapper;
    });

    public static ObjectMapper getJackson() {
        return JACKSON_THREAD_LOCAL.get();
    }
}

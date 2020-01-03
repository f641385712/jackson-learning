package com.youtbatman.java.features;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.junit.Test;

import java.time.LocalDateTime;

public class MapperFeatureTest {

    @Test
    public void fun1() throws JsonProcessingException {
        JsonMapper jsonMapper = new JsonMapper();
        jsonMapper.disable(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT);

        System.out.println(jsonMapper.writeValueAsString(LocalDateTime.now()));
    }
    // String jsonStr = "{\"name\":\"YourBatman\",\"age\":18}";
    // System.out.println(objectMapper.readValue(jsonStr, Person.class));
    // }
}

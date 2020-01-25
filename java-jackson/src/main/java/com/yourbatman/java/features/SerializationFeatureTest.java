package com.yourbatman.java.features;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.junit.Test;

public class SerializationFeatureTest {

    @Test
    public void fun1() throws JsonProcessingException {
        JsonMapper jsonMapper = new JsonMapper();

        System.out.println(jsonMapper.writeValueAsString(new Person()));
    }
}


package com.yourbatman.spring.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Jackson2ObjectMapperBuilderTest {

    @Test
    public void fun1() throws JsonProcessingException {
        ObjectMapper mapper = Jackson2ObjectMapperBuilder.json()
                .dateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"))
                .build();

        System.out.println(mapper.writeValueAsString(new Date()));
    }

}

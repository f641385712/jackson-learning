package com.yourbatman.java.annotation;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class AnnotationTest3 {


    @Test
    public void fun1() throws JsonProcessingException {
        JsonMapper mapper = new JsonMapper();

        System.out.println(mapper.writeValueAsString(new Person()));
    }

    @Test
    public void fun2() throws JsonProcessingException {
        JsonMapper mapper = new JsonMapper();

        // 反序列化
        String jsonStr = "{\"name\":\"YourBatman\",\"age\":18,\"birthDay\":\"2020-01-20 19:54:02\"}";
        // String jsonStr = "{\"name\":\"YourBatman\",\"age\":18,\"birthDay\":\"2020-01-20T19:54:02.0000\"}";
        Person person = mapper.readValue(jsonStr, Person.class);
        System.out.println(person);
    }


    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Setter
    @ToString
    private static class Person {
        private String name = "YourBatman";
        private Integer age = 18;
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",shape = JsonFormat.Shape.ANY,timezone = "GMT+8")
        private Date birthDay = new Date();
    }

}

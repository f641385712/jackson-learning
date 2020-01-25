package com.yourbatman.java.moduls;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.junit.Test;

import java.sql.SQLOutput;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Jsr310Test {

    @Test
    public void fun1() throws JsonProcessingException {
        JsonMapper mapper = new JsonMapper();
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mapper.registerModule(new JavaTimeModule());

        System.out.println(mapper.writeValueAsString(LocalDateTime.now()));
        System.out.println(mapper.writeValueAsString(LocalDate.now()));
        System.out.println(mapper.writeValueAsString(LocalTime.now()));
        System.out.println(mapper.writeValueAsString(Instant.now()));
    }


    @Test
    public void fun2() throws JsonProcessingException {
        JsonMapper mapper = new JsonMapper();
        mapper.registerModule(new JavaTimeModule());

        // LocalDateTime:这个T不能省也不能换成其它的。具体毫秒值可有可无
        // System.out.println(mapper.readValue("{\"localDateTime\":\"2020-01-24T15:17:00\"}",Person.class));

        // LocalDate:
        // System.out.println(mapper.readValue("{\"localDate\":\"2020-01-24\"}",Person.class));

        // LocalTime:毫秒值可要可不要
        // System.out.println(mapper.readValue("{\"localTime\":\"15:17:00.11\"}",Person.class));


        // Instant：可以是毫秒值（但是默认只能精确到秒哦，也就是除以1000的）
        System.out.println(mapper.readValue("{\"instant\":1579851955}",Person.class));
        // Instant：这种字符串也是能够被正常反序列化的
        System.out.println(mapper.readValue("{\"instant\":\"2020-01-24T10:15:30Z\"}",Person.class));

    }


    @Setter
    @ToString
    private static class Person{
        private Instant instant;
    }

}

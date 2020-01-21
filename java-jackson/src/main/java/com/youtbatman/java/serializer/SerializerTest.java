package com.youtbatman.java.serializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.junit.Test;

import java.net.InetSocketAddress;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class SerializerTest {

    @Test
    public void fun1() throws JsonProcessingException {
        JsonMapper jsonMapper = new JsonMapper();

        Map<Integer, String> map = new HashMap<>();
        map.put(1, "1");
        map.put(2, "2");
        map.put(3, "3");

        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(jsonMapper.writeValueAsString(entry));
        }
    }

    @Test
    public void fun2() throws JsonProcessingException {
        JsonMapper jsonMapper = new JsonMapper();

        Map<Integer, String> map = new HashMap<>();
        map.put(1, "1");
        map.put(2, "2");
        map.put(3, "3");

        System.out.println(jsonMapper.writeValueAsString(map));
    }


    @Test
    public void fun3() throws JsonProcessingException {
        JsonMapper jsonMapper = new JsonMapper();

        System.out.println(jsonMapper.writeValueAsString(Arrays.asList(1, 2, 3)));
        System.out.println(jsonMapper.writeValueAsString(Arrays.asList("1", "2", "3")));

        System.out.println(jsonMapper.writeValueAsString(new Integer[]{1, 2, 3}));
        System.out.println(jsonMapper.writeValueAsString(new Character[]{'1', '2', '3'}));
        System.out.println(jsonMapper.writeValueAsString(new String[]{"1", "2", "3"}));
    }


    @Test
    public void fun4() throws JsonProcessingException {
        JsonMapper jsonMapper = new JsonMapper();

        System.out.println(jsonMapper.writeValueAsString("hello world"));
    }


    @Test
    public void fun5() throws JsonProcessingException {
        JsonMapper jsonMapper = new JsonMapper();

        System.out.println(jsonMapper.writeValueAsString(UUID.randomUUID()));
    }

    @Test
    public void fun6() throws JsonProcessingException {
        JsonMapper jsonMapper = new JsonMapper();

        System.out.println(jsonMapper.writeValueAsString(InetSocketAddress.createUnresolved("localhost", 8080)));
    }


    @Test
    public void fun7() throws JsonProcessingException {
        JsonMapper jsonMapper = new JsonMapper();
        jsonMapper.enable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        System.out.println(jsonMapper.writeValueAsString(LocalDateTime.now()));
        System.out.println(jsonMapper.writeValueAsString(LocalDate.now()));
        System.out.println(jsonMapper.writeValueAsString(LocalTime.now()));
        System.out.println(jsonMapper.writeValueAsString(Instant.now()));
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Setter
    @ToString
    private static class Person {
        private String name = "YourBatman";
        private Integer age = 18;
        private Date birthDay;
        private Long birthDayLong; // 很多人喜欢用Long表示时间
        private String remark; // 特意让其为null
    }


}


package com.yourbatman.spring.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;


@RestController
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    ObjectMapper mapper;

    @GetMapping("/objectMapper2")
    public Object objectMapper2() throws Exception {
        return mapper.writeValueAsString(new Date());
    }



    @GetMapping("/objectMapper1")
    public Object objectMapper1() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(new Date());
    }

    @GetMapping("/get")
    public Object get() {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("date", new Date());
        map.put("timestamp", new Timestamp(System.currentTimeMillis()));
        map.put("localDateTime", LocalDateTime.now());
        map.put("localDate", LocalDate.now());
        map.put("localTime", LocalTime.now());
        map.put("instant", Instant.now());
        return map;
    }


    @PostMapping("/post")
    public Object post(@RequestBody Demo demo) {
        System.out.println(demo);
        return "success";
    }

    @Setter
    @ToString
    private static class Demo {
        private Date date;
        // private Timestamp timestamp; // 它没有空构造，所以默认不能被反序列化
        private LocalDateTime localDateTime;
        private LocalDate localDate;
        private LocalTime localTime;
        private Instant instant;
    }
}

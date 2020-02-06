package com.yourbatman.springboot2.controller;

import org.springframework.web.bind.annotation.GetMapping;
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

}

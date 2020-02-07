// package com.yourbatman.springboot2;
//
// import com.fasterxml.jackson.core.JsonProcessingException;
// import com.fasterxml.jackson.databind.ObjectMapper;
// import org.junit.Test;
// import org.junit.runner.RunWith;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
// import org.springframework.test.context.junit4.SpringRunner;
//
// import java.sql.Timestamp;
// import java.time.Instant;
// import java.time.LocalDate;
// import java.time.LocalDateTime;
// import java.time.LocalTime;
// import java.util.Date;
// import java.util.LinkedHashMap;
// import java.util.Map;
//
// @RunWith(SpringRunner.class)
// @SpringBootTest
// public class Springboot2JacksonApplicationTests {
//
//     @Autowired
//     ObjectMapper objectMapper;
//     @Test
//     public void contextLoads() throws JsonProcessingException {
//         Map<String, Object> map = new LinkedHashMap<>();
//         map.put("date", new Date());
//         map.put("timestamp", new Timestamp(System.currentTimeMillis()));
//         map.put("localDateTime", LocalDateTime.now());
//         map.put("localDate", LocalDate.now());
//         map.put("localTime", LocalTime.now());
//         map.put("instant", Instant.now());
//
//         System.out.println(objectMapper.writeValueAsString(map));
//     }
//
// }

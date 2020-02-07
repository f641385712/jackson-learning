// package com.yourbatman.springboot2;
//
// import com.fasterxml.jackson.core.JsonProcessingException;
// import com.fasterxml.jackson.databind.ObjectMapper;
// import com.fasterxml.jackson.databind.SerializationFeature;
// import org.junit.Test;
// import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
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
// public class NormerTest {
//
//     @Test
//     public void fun1() throws JsonProcessingException {
//         ObjectMapper mapper = Jackson2ObjectMapperBuilder.json().build();
//         mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
//
//         Map<String, Object> map = new LinkedHashMap<>();
//         map.put("date", new Date());
//         map.put("timestamp", new Timestamp(System.currentTimeMillis()));
//         map.put("localDateTime", LocalDateTime.now());
//         map.put("localDate", LocalDate.now());
//         map.put("localTime", LocalTime.now());
//         map.put("instant", Instant.now());
//
//         System.out.println(mapper.writeValueAsString(map));
//     }
//
// }

package com.yourbatman.java.features;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.junit.Test;

import java.util.Date;

public class DeserializationFeatureTest {

    @Test
    public void fun1() throws JsonProcessingException {
        JsonMapper jsonMapper = new JsonMapper();
        // jsonMapper.disable(DeserializationFeature.READ_DATE_TIMESTAMPS_AS_NANOSECONDS);

        String jsonStr = "{\"name\":\"YourBatman\", \"age\": 18, \"date\" : 1577969331814}";
        Person person = jsonMapper.readValue(jsonStr, Person.class);

        System.out.println(person);
    }
}

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
class Person {
    private String name;
    private Integer age;
    private Date date;
    private Object nums;
}
package com.youtbatman.java.features;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.junit.Test;

public class MapperFeatureTest {

    @Test
    public void fun1() throws JsonProcessingException {
        JsonMapper objectMapper = new JsonMapper();
        objectMapper.enable(MapperFeature.USE_WRAPPER_NAME_AS_PROPERTY_NAME);

        Person person = new Person();
        person.setName("YourBatman");
        person.setAge(18);
        System.out.println(objectMapper.writeValueAsString(person));

        // String jsonStr = "{\"name\":\"YourBatman\",\"age\":18}";
        // System.out.println(objectMapper.readValue(jsonStr, Person.class));
    }
}


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
class Person {
    public String name;
    private Number age;
}

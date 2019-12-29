package com.youtbatman.java.databind;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.youtbatman.java.bean.Color;
import com.youtbatman.java.bean.Data;
import com.youtbatman.java.bean.Dog;
import com.youtbatman.java.bean.Person;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class GenericReadWriteTest {

    @Test
    public void readAndWrite() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        Person person = new Person();
        person.setName("YourBatman");
        person.setAge(18);
        person.setIds(Arrays.asList(1L,2L,3L));

        String jsonStr = objectMapper.writeValueAsString(Arrays.asList(person));
        System.out.println(jsonStr);

        // 读取，并且反序列化为Person对象
        List<Person>  personList= objectMapper.readValue(jsonStr, List.class);
        System.out.println(personList);
    }

    @Test
    public void readGeneric() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String idsStr = "[1,2,3]";

        List<Long> list = objectMapper.readValue(idsStr, new TypeReference<List<Long>>() {});
        Long i1 = list.get(0);
        System.out.println(list);
    }
}

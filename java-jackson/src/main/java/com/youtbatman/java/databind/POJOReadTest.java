package com.youtbatman.java.databind;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.youtbatman.java.bean.Person;

import java.io.File;
import java.io.IOException;

public class POJOReadTest {

    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        Person person = objectMapper.readValue(new File("java-jackson/src/main/resources/person.json"), Person.class);
        System.out.println(person);
    }
}

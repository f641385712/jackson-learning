package com.youtbatman.java.moduls;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import com.youtbatman.java.moduls.beans.Person;
import org.junit.Test;

public class ParameterTest {

    @Test
    public void fun1() throws JsonProcessingException {
        JsonMapper mapper = new JsonMapper();
        mapper.registerModule(new ParameterNamesModule());

        String jsonStr = "{\"name\":\"YourBatman\",\"age\":18}";
        Person person = mapper.readValue(jsonStr, Person.class);
        System.out.println(person);
    }

}

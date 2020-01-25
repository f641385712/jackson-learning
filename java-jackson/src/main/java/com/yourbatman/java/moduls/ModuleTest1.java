package com.yourbatman.java.moduls;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.junit.Test;

import java.util.Date;

public class ModuleTest1 {

    @Test
    public void fun1() throws JsonProcessingException {
        JsonMapper mapper = new JsonMapper();

        SimpleModule simpleModule = new SimpleModule("moduleTest");
        mapper.registerModule(simpleModule);

        System.out.println(mapper.writeValueAsString(new Date()));
    }
}

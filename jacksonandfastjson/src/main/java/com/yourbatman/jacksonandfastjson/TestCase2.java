package com.yourbatman.jacksonandfastjson;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yourbatman.jacksonandfastjson.beans.Person;
import org.junit.Test;

public class TestCase2 {

    @Test
    public void fun2() {
        Person person = new Person();

        fastjsonSer(person);
        jacksonSer(new ObjectMapper(), person);
    }

    private static void jacksonSer(ObjectMapper mapper, Object obj) {
        try {
            System.out.println("jackson：" + mapper.writeValueAsString(obj));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
    private static void fastjsonSer(Object obj) {
        System.out.println("fastjson：" + JSON.toJSONString(obj));
    }
}

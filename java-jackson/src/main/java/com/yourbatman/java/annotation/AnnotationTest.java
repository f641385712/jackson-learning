package com.yourbatman.java.annotation;

import com.fasterxml.jackson.annotation.JacksonInject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.InjectableValues;
import com.fasterxml.jackson.databind.json.JsonMapper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.junit.Test;

import java.util.Date;

public class AnnotationTest {

    @Test
    public void fun1() throws JsonProcessingException {
        JsonMapper mapper = new JsonMapper();

        InjectableValues.Std injectableValues = new InjectableValues.Std();
        injectableValues.addValue("defaultName", "inject-YourBatman");
        injectableValues.addValue("defaultAge", 20);
        //当然也可以根据类型来设置，形如这样（当同时存在时以id精确匹配为准）
        injectableValues.addValue(String.class, "inject-defaultStr");
        mapper.setInjectableValues(injectableValues);

        // 反序列化
        String jsonStr = "{\"birthDay\": \"2020-01-17\"}";
        Person person = mapper.readValue(jsonStr, Person.class);
        System.out.println(person);
    }


    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Setter
    @ToString
    private static class Person {

        @JacksonInject(value = "defaultName")
        private String name = "YourBatman";
        @JacksonInject(value = "defaultAge")
        private Integer age = 18;
        private Date birthDay;
        private Long birthDayLong;

        @JacksonInject
        private String remark;
    }
}

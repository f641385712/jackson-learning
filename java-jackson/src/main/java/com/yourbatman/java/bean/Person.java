package com.yourbatman.java.bean;

import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.util.List;

@Data
public class Person {
    private List<Long> ids;


    @JsonSerialize(using = JsonSerializer.None.class)
    private String name;
    private Integer age;
    private List<String> hobbies;

    // 测试内置泛型类型

    private Dog dog;
}

package com.youtbatman.java.bean;

import lombok.Data;

import java.util.List;

@Data
public class Person {
    private List<Long> ids;



    private String name;
    private Integer age;
    private List<String> hobbies;

    // 测试内置泛型类型

    private Dog dog;
}

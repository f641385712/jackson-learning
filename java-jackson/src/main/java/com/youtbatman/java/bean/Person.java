package com.youtbatman.java.bean;

import lombok.Data;

import java.util.List;

@Data
public class Person {
    private String name;
    private Integer age;
    private List<String> hobbies;

    private Dog dog;
}

package com.yourbatman.jacksonandfastjson.beans;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.ToString;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NON_PRIVATE)
@ToString
public class Person {
    protected String name = "YourBatman";
    Integer age = 18;
}

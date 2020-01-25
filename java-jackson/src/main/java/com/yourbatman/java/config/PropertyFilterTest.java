package com.yourbatman.java.config;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.junit.Test;

public class PropertyFilterTest {

    @Test
    public void fun1() throws JsonProcessingException {
        JsonMapper jsonMapper = new JsonMapper();

        SimpleFilterProvider filterProvider = new SimpleFilterProvider();
        filterProvider.addFilter("all", SimpleBeanPropertyFilter.serializeAll());
        filterProvider.addFilter("diy", SimpleBeanPropertyFilter.serializeAllExcept("name"));
        jsonMapper.setFilterProvider(filterProvider);

        System.out.println(jsonMapper.writeValueAsString(new PropertyFilterDemoBean()));
    }
}


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@JsonFilter("diy")
class PropertyFilterDemoBean {
    private String name = "YourBatman";
    private Integer age = 18;
}
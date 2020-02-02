package com.yourbatman.spring.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.Jackson2ObjectMapperFactoryBean;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Jackson2ObjectMapperFactoryBeanTest {

    @Bean
    public Jackson2ObjectMapperFactoryBean objectMapper() {
        Jackson2ObjectMapperFactoryBean objectMapper = new Jackson2ObjectMapperFactoryBean();
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        return objectMapper;
    }

    @Test
    public void fun1() throws JsonProcessingException {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Jackson2ObjectMapperFactoryBeanTest.class);

        ObjectMapper mapper = applicationContext.getBean(ObjectMapper.class);
        System.out.println(mapper.writeValueAsString(new Date()));
    }
}

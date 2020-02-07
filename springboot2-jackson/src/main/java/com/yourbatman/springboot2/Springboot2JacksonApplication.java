package com.yourbatman.springboot2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Springboot2JacksonApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot2JacksonApplication.class, args);
    }

}

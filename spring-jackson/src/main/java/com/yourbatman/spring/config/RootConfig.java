package com.yourbatman.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestControllerAdvice;


/**
 * 根容器配置类
 *
 * @author yourbatman
 * @date 2020/1/25 16:55
 */
@ComponentScan(value = "com.yourbatman.spring", excludeFilters = {
        @Filter(type = FilterType.ANNOTATION, classes = {Controller.class, ControllerAdvice.class, RestControllerAdvice.class}),
        @Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {WebMvcConfig.class}),
})
@Configuration
public class RootConfig {

}




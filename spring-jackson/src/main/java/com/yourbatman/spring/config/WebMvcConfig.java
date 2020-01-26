package com.yourbatman.spring.config;


import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * web子容器初始化的配置
 *
 * @author yourbatman
 * @date 2020/1/25 16:56
 */
@ComponentScan(value = "com.yourbatman.spring", useDefaultFilters = false,
        includeFilters = {@Filter(type = FilterType.ANNOTATION, classes = {Controller.class, ControllerAdvice.class, RestControllerAdvice.class})}
)
@EnableWebMvc
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.forEach(c -> {
            Class<AbstractJackson2HttpMessageConverter> jacksonClazz = AbstractJackson2HttpMessageConverter.class;
            if (jacksonClazz.isAssignableFrom(c.getClass())) {
                AbstractJackson2HttpMessageConverter jacksonConverter = jacksonClazz.cast(c);
                jacksonConverter.getObjectMapper().disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            }
        });
    }
}

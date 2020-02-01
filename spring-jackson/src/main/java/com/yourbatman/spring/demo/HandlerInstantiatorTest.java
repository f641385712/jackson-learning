package com.yourbatman.spring.demo;

import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.KeyDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.cfg.HandlerInstantiator;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.jsontype.TypeIdResolver;
import com.fasterxml.jackson.databind.jsontype.TypeResolverBuilder;
import com.fasterxml.jackson.databind.util.Converter;
import com.yourbatman.spring.beans.Person;
import org.junit.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.SpringHandlerInstantiator;

public class HandlerInstantiatorTest {

    @Test
    public void fun1() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setHandlerInstantiator(new MyHandlerInstantiator());

        System.out.println(mapper.writeValueAsString(new Person("YoutBatman", 18)));
    }


    @Test
    public void fun2() throws Exception {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(HandlerInstantiatorTest.class);


        ObjectMapper mapper = new ObjectMapper();
        // mapper.setHandlerInstantiator(new MyHandlerInstantiator());
        // 请注意：此处必须使用Spring容器内的MyHandlerInstantiator实例
        mapper.setHandlerInstantiator(applicationContext.getBean(MyHandlerInstantiator.class));
        System.out.println(mapper.writeValueAsString(new Person("YoutBatman", 18)));
    }


    @Test
    public void fun3() throws Exception {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(HandlerInstantiatorTest.class);

        ObjectMapper mapper = new ObjectMapper();
        mapper.setHandlerInstantiator(new SpringHandlerInstantiator(applicationContext.getAutowireCapableBeanFactory()));
        System.out.println(mapper.writeValueAsString(new Person("YoutBatman", 18)));
    }

    @Test
    public void fun4() throws Exception {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(HandlerInstantiatorTest.class);

        ObjectMapper mapper = Jackson2ObjectMapperBuilder.json()
                .applicationContext(applicationContext)
                .build();
        System.out.println(mapper.writeValueAsString(new Person("YoutBatman", 18)));
    }

    // // 把HandlerInstantiator交给Spring容器，因为要使用容器内的Bean
    // @Bean
    // public HandlerInstantiator handlerInstantiator() {
    //     return new MyHandlerInstantiator();
    // }
}

class MyHandlerInstantiator extends HandlerInstantiator {

    @Override
    public JsonDeserializer<?> deserializerInstance(DeserializationConfig config, Annotated annotated, Class<?> deserClass) {
        return null;
    }

    @Override
    public KeyDeserializer keyDeserializerInstance(DeserializationConfig config, Annotated annotated, Class<?> keyDeserClass) {
        return null;
    }

    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public JsonSerializer<?> serializerInstance(SerializationConfig config, Annotated annotated, Class<?> serClass) {
        System.out.println("Spring容器上下文ID：" + applicationContext.getId());

        System.out.println(serClass.getName());
        return (JsonSerializer<?>) BeanUtils.instantiateClass(serClass);
    }

    @Override
    public Converter<?, ?> converterInstance(MapperConfig<?> config, Annotated annotated, Class<?> implClass) {
        System.out.println(implClass.getName());
        return (Converter<?, ?>) BeanUtils.instantiateClass(implClass);
    }

    @Override
    public TypeResolverBuilder<?> typeResolverBuilderInstance(MapperConfig<?> config, Annotated annotated, Class<?> builderClass) {
        return null;
    }

    @Override
    public TypeIdResolver typeIdResolverInstance(MapperConfig<?> config, Annotated annotated, Class<?> resolverClass) {
        return null;
    }
}

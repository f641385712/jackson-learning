package com.youtbatman.java.moduls;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import org.junit.Test;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class JDK8ModuleTest {

    @Test
    public void fun1() throws JsonProcessingException {
        JsonMapper mapper = new JsonMapper();

        mapper.registerModule(new Jdk8Module());
        System.out.println("注册JDK8模块后：");

        System.out.println(mapper.writeValueAsString(OptionalInt.of(1)));
        System.out.println(mapper.writeValueAsString(Optional.of("YourBatman")));
        System.out.println(mapper.writeValueAsString(IntStream.of(1,2,3)));
        System.out.println(mapper.writeValueAsString(Stream.of("1","2","3")));
    }
}

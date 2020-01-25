package com.yourbatman.java.annotation;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class AnnotationTest2 {

    @Test
    public void fun1() throws JsonProcessingException {
        JsonMapper mapper = new JsonMapper();

        // 序列化
        Person person = new Person();
        person.setOthers("birthday", new Date());
        System.out.println(mapper.writeValueAsString(person));

        System.out.println("===================================");

        String jsonStr = "{\"name\":\"YourBatman\",\"age\":18,\"birthday\":1579507504476}";
        person = mapper.readValue(jsonStr, Person.class);
        System.out.println(person);
    }


    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Setter
    @ToString
    private static class Person {
        private String name = "YourBatman";
        private Integer age = 18;
        private Map<String, Object> others = new HashMap<>();

        // 序列化时，输出不认识的key们
        @JsonAnyGetter
        public Map<String, Object> getOthers() {
            return others;
        }

        // 反序列化时收集不认识的key们
        @JsonAnySetter
        public void setOthers(String key, Object value) {
            this.others.put(key, value);
        }
    }


    @Test
    public void fun3() throws Exception {
        JsonMapper jsonMapper = new JsonMapper();
        TestPOJO testPOJO = new TestPOJO();
        testPOJO.setA("1");
        testPOJO.setB("2");
        testPOJO.setC("3");
        testPOJO.setD("4");

        // jsonMapper.configure(MapperFeature.DEFAULT_VIEW_INCLUSION, false);
        String jsonStr = jsonMapper.writerWithView(FilterView.OutputA.class).writeValueAsString(testPOJO);
        System.out.println("视图A：" + jsonStr);
        String jsonStr2 = jsonMapper.writerWithView(FilterView.OutputB.class).writeValueAsString(testPOJO);
        System.out.println("视图B：" + jsonStr2);
    }


    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Setter
    @ToString
    public static class TestPOJO {
        // 视图A
        @JsonView(FilterView.OutputA.class)
        private String a;

        private String c;

        // 视图B
        @JsonView(FilterView.OutputB.class)
        private String d;
        @JsonView(FilterView.OutputB.class)
        private String b;
    }


    // 控制视图输出
    private interface FilterView {
        interface OutputA {
        }

        interface OutputB {
        }
    }


    @Test
    public void fun5() throws JsonProcessingException {
        JsonMapper mapper = new JsonMapper();

        // 序列化
        TestIgIgnoreType testIgIgnoreType = new TestIgIgnoreType();
        System.out.println(mapper.writeValueAsString(testIgIgnoreType));
    }

    // @JsonIgnoreType
    @Getter
    private static class TestIgIgnoreType {
        private Long id = 1L;
        private String name = "strName";
    }

    @Test
    public void fun6() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        String value = objectMapper.writeValueAsString(new User());
        System.out.println(value);
    }

    @Getter
    private static class User {
        @JsonInclude(JsonInclude.Include.NON_NULL)
        private String username;
        private String password;
        private Integer age;
    }
}

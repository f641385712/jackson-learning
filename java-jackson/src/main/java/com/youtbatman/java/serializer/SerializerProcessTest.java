package com.youtbatman.java.serializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.junit.Test;

import java.util.Date;

public class SerializerProcessTest {

    @Test
    public void fun1() throws JsonProcessingException {
        JsonMapper jsonMapper = new JsonMapper();

        // SimpleModule simpleModule = new SimpleModule();
        // simpleModule.addSerializer(Person.class, new PersonSerializer(Person.class));
        // jsonMapper.registerModule(simpleModule);

        Person person = new Person();
        System.out.println(jsonMapper.writeValueAsString(person));
    }


    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Setter
    @ToString
    // @JsonSerialize(using = PersonSerializer.class)
    private static class Person {

        // @JsonValue // "YourBatman"
        private String name = "YourBatman";
        private Integer age = 18;
        private Date birthDay;
        private Long birthDayLong; // 很多人喜欢用Long表示时间
        private String remark; // 特意让其为null
    }


    // private static class PersonSerializer extends StdSerializer<Person> {
    //
    //     // 提供空构造是为了让可以使用注解方式，一般建议提供
    //     public PersonSerializer() {
    //         this(Person.class);
    //     }
    //
    //     protected PersonSerializer(Class<Person> t) {
    //         super(t);
    //     }
    //
    //     @Override
    //     public void serialize(Person value, JsonGenerator gen, SerializerProvider provider) throws IOException {
    //         gen.writeStartObject();
    //         gen.writeStringField("jsonStr", value.toString());
    //         gen.writeEndObject();
    //     }
    // }
}


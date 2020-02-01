package com.yourbatman.spring.beans;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.Converter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import java.io.IOException;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonSerialize(using = PersonSerializer.class, converter = PersonConverter.class)
public class Person {
    private String name;
    private Integer age;
}

class PersonSerializer extends StdSerializer<Person> {
    @Autowired
    ApplicationContext applicationContext;


    public PersonSerializer() {
        this(Person.class);
    }
    protected PersonSerializer(Class<Person> t) {
        super(t);
    }
    @Override
    public void serialize(Person value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        System.out.println("转换器PersonSerializer执行serialize()方法...");
        gen.writeStartObject();
        gen.writeStringField("jsonStr", value.toString());
        gen.writeEndObject();
    }
}

class PersonConverter implements Converter<Person, Person> {
    @Override
    public Person convert(Person person) {
        System.out.println("转换器PersonConverter执行convert()方法...");
        // 比如age的值不能太大，或者不让序列化就可以在此处做文章
        if (person.getAge() > 20) {
            person.setAge(18);
        }
        return person;
    }
    @Override
    public JavaType getInputType(TypeFactory typeFactory) {
        return typeFactory.constructType(Person.class);
    }
    @Override
    public JavaType getOutputType(TypeFactory typeFactory) {
        return typeFactory.constructType(Person.class);
    }
}

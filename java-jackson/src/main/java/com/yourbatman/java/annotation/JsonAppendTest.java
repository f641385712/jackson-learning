package com.yourbatman.java.annotation;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.introspect.AnnotatedClass;
import com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.ser.VirtualBeanPropertyWriter;
import com.fasterxml.jackson.databind.util.Annotations;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.junit.Test;

public class JsonAppendTest {


    @Test
    public void fun1() throws JsonProcessingException {
        JsonMapper mapper = new JsonMapper();

        System.out.println(mapper.writeValueAsString(new Response()));
    }


    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Setter
    @ToString
    @JsonAppend(props = @JsonAppend.Prop(name = "remark", value = MyAgeVirtualBeanPropertyWriter.class))
    @JsonNaming(value = PropertyNamingStrategy.UpperCamelCaseStrategy.class)
    private static class Response {
        private Long id;
        private String name;
    }

    // 生成虚拟属性值
    private static class MyAgeVirtualBeanPropertyWriter extends VirtualBeanPropertyWriter {

        // 必须有个无参构造 否则报错
        public MyAgeVirtualBeanPropertyWriter() {
        }

        private MyAgeVirtualBeanPropertyWriter(BeanPropertyDefinition propDef,
                                               Annotations contextAnnotations, JavaType declaredType) {
            super(propDef, contextAnnotations, declaredType);
        }

        @Override
        protected Object value(Object bean, JsonGenerator gen, SerializerProvider prov) throws Exception {
            return "我是一个虚拟字段的值";
        }

        @Override
        public VirtualBeanPropertyWriter withConfig(MapperConfig<?> config, AnnotatedClass declaringClass, BeanPropertyDefinition propDef, JavaType type) {
            return new MyAgeVirtualBeanPropertyWriter(propDef, null, type);
        }
    }
}

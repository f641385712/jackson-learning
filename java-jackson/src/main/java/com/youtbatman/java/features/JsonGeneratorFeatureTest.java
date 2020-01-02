package com.youtbatman.java.features;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonFactoryBuilder;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.json.JsonWriteFeature;
import org.junit.Test;

import java.io.IOException;
import java.io.PrintWriter;

public class JsonGeneratorFeatureTest {

    @Test
    public void test1() throws IOException {
        JsonFactory factory = new JsonFactory();
        factory.enable(JsonGenerator.Feature.STRICT_DUPLICATE_DETECTION);

        // 输出写到控制台
        JsonGenerator jsonGenerator = factory.createGenerator(new PrintWriter(System.out));

        jsonGenerator.writeStartObject();

        jsonGenerator.writeStringField("name", "YourBatman");
        jsonGenerator.writeStringField("name", "Peter");

        jsonGenerator.writeEndObject();

        // 说明：只有等到这边flush/close了，你的文件/流里才会有值的哦
        jsonGenerator.flush();
        jsonGenerator.close();
    }


    @Test
    public void test2() throws IOException {
        JsonFactory factory = new JsonFactoryBuilder()
                .build();


        // 输出写到控制台
        JsonGenerator jsonGenerator = factory.createGenerator(new PrintWriter(System.out));

        jsonGenerator.writeStartObject();

        jsonGenerator.writeNumberField("money", 1.23);

        jsonGenerator.writeEndObject();

        // 说明：只有等到这边flush/close了，你的文件/流里才会有值的哦
        jsonGenerator.flush();
        jsonGenerator.close();
    }

}

package com.yourbatman.java.features;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonFactoryBuilder;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.json.JsonReadFeature;
import org.junit.Test;

import java.io.IOException;

public class JsonParserFeatureTest {

    @Test
    public void test1() throws IOException {
        JsonFactory factory = new JsonFactory();

        // 输出写到控制台
        String jsonStr = "{\"name\" : \"YourBatman\",\"name\" : \"Perter\"}";
        JsonParser jsonParser = factory.createParser(jsonStr);
        while (jsonParser.nextToken() != JsonToken.END_OBJECT) {
            String fieldname = jsonParser.getCurrentName();
            if ("name".equals(fieldname)) {
                System.out.println(jsonParser.nextTextValue());
            }
        }
        jsonParser.close();
    }


    @Test
    public void test2() {
        String str1 = "a";
        String str2 = "b";
        String str3 = "ab";
        String str4 = str1 + str2;
        String str5 = new String("ab");

        System.out.println(str5.equals(str3)); // true
        System.out.println(str5 == str3); // false

        // str5.intern()去常量池里找到了ab，所以直接返回常量池里的地址值了，因此是true
        System.out.println(str5.intern() == str3); // true
        System.out.println(str5.intern() == str4); // false
    }


    @Test
    public void test3() throws IOException {
        JsonFactory factory = new JsonFactoryBuilder()
                .enable(JsonReadFeature.ALLOW_TRAILING_COMMA)
                .build();

        // 输出写到控制台
        String jsonStr = "{\"name\" : \"YourBatman\",}";
        JsonParser jsonParser = factory.createParser(jsonStr);
        while (jsonParser.nextToken() != JsonToken.END_OBJECT) {
            String fieldname = jsonParser.getCurrentName();
            if ("name".equals(fieldname)) {
                System.out.println(jsonParser.nextTextValue());
            }
        }
        jsonParser.close();
    }
}

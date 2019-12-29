package com.youtbatman.java.databind;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CollectionReadWriteTest {

    @Test
    public void testWrite() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);
        ids.add(3);

        String idsStr = objectMapper.writeValueAsString(ids);
        System.out.println(idsStr); // [1,2,3]
    }

    @Test
    public void testRead() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String idsStr = "[1,2,3]";

        // List list = objectMapper.readValue(idsStr, List.class);
        // System.out.println(list); // [1, 2, 3]

        // List<Long> list = objectMapper.readValue(idsStr, List.class);
        List<Long> list = objectMapper.readValue(idsStr, new TypeReference<List<Long>>() {
        });
        Long i1 = list.get(0);
        System.out.println(list); // [1, 2, 3]
    }

}

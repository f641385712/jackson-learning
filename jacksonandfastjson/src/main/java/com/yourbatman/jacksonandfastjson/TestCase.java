package com.yourbatman.jacksonandfastjson;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class TestCase {

    private static final int MAX = 3000_0000;
    private static final List<Integer> OBJS = new ArrayList<>();

    static {
        for (int i = 0; i < MAX; i++) {
            OBJS.add(i);
        }
    }

    @Test
    public void fun1() {
        System.out.println("MAX为：" + MAX);
        ObjectMapper mapper = new ObjectMapper();

        run("fastjson", () -> JSON.toJSONString(OBJS));
        run("jackson", () -> jacksonSer(mapper, OBJS));
    }


    private static void jacksonSer(ObjectMapper mapper, Object obj) {
        try {
            mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    private static void fastjsonSer(Object obj) {
        JSON.toJSONString(obj);
    }

    // 这里仅是把Runnable当作@FunctionalInterface来使而已，并不是启线程
    private static void run(String name, Runnable task) {
        Instant start = Instant.now();
        task.run();
        Instant end = Instant.now();

        System.out.printf("【%s】耗时： %s 毫秒\n", name, Duration.between(start, end).toMillis());
    }
}

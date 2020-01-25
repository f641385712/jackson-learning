package com.yourbatman.java.config;

import com.fasterxml.jackson.databind.cfg.MapperConfigBase;
import org.junit.Test;

import java.lang.reflect.Field;
import java.time.ZoneOffset;
import java.util.TimeZone;

public class BaseSettingTest {

    @Test
    public void fun1() {
        System.out.println(TimeZone.getDefault());
        System.out.println(TimeZone.getTimeZone("Asia/Shanghai"));
        System.out.println(TimeZone.getTimeZone("GMT+8"));
        System.out.println(TimeZone.getTimeZone("GMT+8:00"));
        System.out.println(TimeZone.getTimeZone("GMT"));
        System.out.println(TimeZone.getTimeZone("UTC"));
        System.out.println(TimeZone.getTimeZone("UTC+8"));


        // ZoneOffset
        System.out.println(ZoneOffset.systemDefault());
        // System.out.println(ZoneOffset.of("Asia/Shanghai")); //抛错
        // System.out.println(ZoneOffset.of("+8:00")); // 抛错
        System.out.println(ZoneOffset.of("+08:00"));
        System.out.println(ZoneOffset.ofHours(8));
        // System.out.println(ZoneOffset.of("GMT")); // 抛错
    }

    @Test
    public void fun2() throws NoSuchFieldException, IllegalAccessException {
        Field auto_detect_mask = MapperConfigBase.class.getDeclaredField("AUTO_DETECT_MASK");
        auto_detect_mask.setAccessible(true);

        Object o = auto_detect_mask.get(null);
        System.out.println(o);
        System.out.println(Integer.toBinaryString(Integer.valueOf(o.toString())));
    }

}

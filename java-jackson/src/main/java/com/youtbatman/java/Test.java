package com.youtbatman.java;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {

    private static List<String> stringList = new ArrayList<>();
    private static List<Integer> integerList = new ArrayList<>();

    public static void main(String... args) throws Exception {
        //Field它编译过后是还能访问到泛型类型的
        Field stringListField = Test.class.getDeclaredField("stringList");
        ParameterizedType stringListType = (ParameterizedType) stringListField.getGenericType();
        Class<?> stringListClass = (Class<?>) stringListType.getActualTypeArguments()[0];
        System.out.println(stringListClass); // class java.lang.String.

        Field integerListField = Test.class.getDeclaredField("integerList");
        ParameterizedType integerListType = (ParameterizedType) integerListField.getGenericType();
        Class<?> integerListClass = (Class<?>) integerListType.getActualTypeArguments()[0];
        System.out.println(integerListClass); // class java.lang.Integer.


        // =====泛型擦除===== 直接从该实例本身去去访问就访问不到喽
        // ===============因为方法入参上的泛型，在运行期都是不会起作用的。这就是为何List<Integer>里面能装Long值的原因===============
        Class<? extends List> stringClazz = stringList.getClass();
        Class<? extends List> integerClazz = integerList.getClass();
        System.out.println(stringClazz); // class java.util.ArrayList
        System.out.println(integerClazz); // class java.util.ArrayList
        System.out.println(stringClazz == integerClazz); // true


        // 获取父类上的泛型类型
        ParameterizedType parametclass = (ParameterizedType) stringList.getClass().getGenericSuperclass();
        Type[] actualTypeArguments = parametclass.getActualTypeArguments();
        System.out.println(actualTypeArguments[0]); // E
        System.out.println(actualTypeArguments[0].getTypeName()); // E
        System.out.println(actualTypeArguments[0].getClass()); // class sun.reflect.generics.reflectiveObjects.TypeVariableImpl
    }


    @org.junit.Test
    public void fun1() {
        System.out.println(1 << 3);
    }


    @org.junit.Test
    public void fun2(){
        // 2 -> 10
        // 3 -> 11
        // 异或后结果：01（二进制数）
        System.out.println(Integer.toBinaryString(2 ^ 3));
    }


}

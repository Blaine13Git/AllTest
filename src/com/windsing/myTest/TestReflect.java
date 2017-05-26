package com.windsing.myTest;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by fch96 on 2017/5/26.
 * 通过反射，了解类的内部信息
 */
public class TestReflect {

    public static void main(String[] args) throws ClassNotFoundException {
        Class<String> c1 = String.class;

        String a = "abc";
        Class<? extends String> c2 = a.getClass();

        Class<?> c3 = Class.forName("java.lang.String");

        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3.getPackage());

        Class<?> aClass = Class.forName("com.windsing.myTest.ThreadTest");


        // 获取成员方法
        Method[] declaredMethods = aClass.getDeclaredMethods();
        for(Method m:declaredMethods){
            String name = m.getName();
            System.out.println(name);
        }

        // 获取成员变量
        Field[] declaredFields = aClass.getDeclaredFields();
        for(Field f:declaredFields){
            String name = f.getName();
            f.getType();
            System.out.println(name);
        }


        System.out.println();

    }
}

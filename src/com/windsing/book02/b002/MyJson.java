package com.windsing.book02.b002;


import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by FC on 2017/4/14.
 */
public class MyJson {

    static void test001() {
        People p = new People("tom1",12,"asd");
        JSONObject jsonObject = new JSONObject(p);
        String s = jsonObject.toString();
        System.out.println(s);
    }

    public static void main(String[] args) {
        test001();
        System.out.println();
    }
}

class People {
    String name;
    int age;
    String address;

    People(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public void test001() {
        List<People> peoples = new ArrayList<>();
        peoples.add(new People("tom1",12,"asd"));
        peoples.add(new People("tom2",13,"asdf"));
        peoples.add(new People("tom3",14,"asdfg"));
    }
}
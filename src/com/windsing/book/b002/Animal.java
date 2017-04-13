package com.windsing.book.b002;

import java.io.Serializable;

import static java.lang.System.out;

/**
 * Created by FC on 2017/4/12.
 */
public class Animal implements Serializable {
    String name;
    int age;
    String address;

    public Animal(String name){
        this.name = name;
    }
    public Animal(String name, int age){

    }

    protected void eating(){
        out.println("eating now");
    }

    protected void sleeping(){
        out.println("sleeping now");
    }
}

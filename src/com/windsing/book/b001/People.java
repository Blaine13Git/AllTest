package com.windsing.book.b001;

import java.io.Serializable;

import static java.lang.System.out;

/**
 * Created by FC on 2017/4/12.
 */
public class People implements Serializable {
    String name;
    int age;
    long id;
    String address;

    public People(String name){
        this.name = name;
    }
    public People(String name,int age){

    }
    public People(String name,long id){

    }

    protected void eating(){
        out.println("eating now");
    }

    protected void sleeping(){
        out.println("sleeping now");
    }
}

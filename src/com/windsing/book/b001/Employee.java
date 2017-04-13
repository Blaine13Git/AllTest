package com.windsing.book.b001;

import java.io.Serializable;
import java.util.Date;

import static java.lang.System.out;

/**
 * Created by fch96 on 2017/4/12.
 */
public class Employee implements Serializable {
    private String name;
    private double salary;

    public String getName() {
        return name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public void raiseSalary(double addSalary){
        salary +=addSalary;
    }
}
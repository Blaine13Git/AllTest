package com.windsing.book.b001;

/**
 * Created by fch96 on 2017/4/12.
 */
public class Manager {

    private String name;
    private double salary;
    private Employee secretary;

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Employee getSecretary() {
        return secretary;
    }

    public void setSecretary(Employee e) {
        this.secretary = e;
    }

    public Manager(String name) {
        this.name = name;
    }

}

package com.windsing.book;

import java.io.FileInputStream;
import java.io.PrintWriter;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

import static java.lang.System.out;

/**
 * Created by fch96 on 2017/4/9.
 */
public class TextFileTest {

    public static void main(String[] args) throws Exception {

        Employee[] staff = new Employee[3];
        staff[0] = new Employee("Carl Cracker", 75000, 1987, 12, 15);
        staff[1] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
        staff[2] = new Employee("Tony Tester", 40000, 1990, 3, 5);

        /**
         * 保存所有员工记录
         */
        // try(){},自动资源管理
        // (……)支持包括流以及任何可关闭的资源
        // 必须实现 java.lang.AutoCloseable 接口
        try (PrintWriter out = new PrintWriter("./source/employee.dat", "UTF-8")) {
            writeData(staff, out);
        }

        /**
         * 重新获取所有员工数据到数组中
         *
         */
        try (Scanner in = new Scanner(new FileInputStream("./source/employee.dat"), "UTF-8")) {

        }
    }

    static void writeData(Employee[] employees, PrintWriter out) {
        out.print(employees.length);
        for (Employee e : employees) {

        }
    }

    static Employee[] readData(Scanner in) {
        /**
         * 重新获取数组的大小
         *
         */
        int n = in.nextInt();
        in.nextLine();
        Employee[] employees = new Employee[n];
        for (int i = 0; i < n; i++) {

        }
        return employees;

    }

    static void writeEmployee(PrintWriter out, Employee e) {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(e.getHireDay());

        out.println();
    }

    static Employee readEmployee(Scanner in) {

        String line = in.nextLine();
        String[] tokens = line.split("\\|");
        String name = tokens[0];
        double salary = Double.parseDouble(tokens[1]);
        int year = Integer.parseInt(tokens[2]);
        int month = Integer.parseInt(tokens[3]);
        int day = Integer.parseInt(tokens[4]);

        return new Employee(name, salary, year, month, day);
    }
}

class Employee {
    private Date hireDay;
    private String name;
    private double salary;

    public void setHireDay(Date hireDay) {
        this.hireDay = hireDay;
    }

    public Date getHireDay() {
        return hireDay;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public Employee(String name, double salary, int year, int month, int day) {
        out.println("add employee:" + name);
    }
}
package com.windsing.book;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

/**
 * Created by fch96 on 2017/4/12.
 */
public class ObjWrite {
    public static void test_001() throws Exception {
        Employee carl = new Employee("Carl Cracker", 75000);
        Employee hrry = new Employee("Harry Hacker", 50000);
        Employee tony = new Employee("Tony Tester", 40000);
        Employee mm = new Employee("MM", 60000);

        List<Employee> employees = new ArrayList<>();
        employees.add(carl);
        employees.add(hrry);
        employees.add(tony);
        employees.add(mm);

        Manager manager = new Manager("BBL");
        manager.setSecretary(mm);

        try (ObjectOutputStream write = new ObjectOutputStream(new FileOutputStream("./source/employee.dat"))) {
            write.writeObject(employees);
        }

        try (ObjectInputStream read = new ObjectInputStream(new FileInputStream("./source/employee.dat"))) {
            List<Employee> newEmployee = (List<Employee>) read.readObject();
            newEmployee.get(3).raiseSalary(2000);

            for (Employee e : newEmployee) {
                out.println(e);
            }
        }
    }

    public static void test_002() throws Exception {
//        try(BufferedReader buffer = new BufferedReader(new FileReader("./source/employee.dat"))){
//            String s = buffer.readLine();
//            out.println(s);
//        }
        try (InputStream in = new FileInputStream("./source/employee.dat")) {
            for (int i = 0; i < 20; i++) {
                int b = in.read();
                out.println(Integer.toHexString(b));
            }
        }

    }

    public static void main(String[] args) throws Exception {
        test_002();
    }

}

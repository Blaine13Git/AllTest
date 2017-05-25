package com.windsing.book.b001;

import java.io.*;

import static java.lang.System.out;

/**
 * Created by FC on 2017/4/12.
 */
public class InputOutPut {
    static String file_name = "./source/InputOutput.dat";

    public static void write2File() throws Exception {
        try (PrintWriter writer = new PrintWriter(file_name);) {
            writer.println("123");
            writer.print("123");
            writer.print("123");
            writer.print("123");
        }

    }

    public static void readFromFile() throws Exception {
        try (BufferedReader reader = new BufferedReader(new FileReader(file_name))) {
            out.println(reader.readLine());
        }
    }

    public static void writeObj2File() throws Exception{
        People p = new People("TOM");
        Animal a = new Animal("B");

        try (ObjectOutputStream write = new ObjectOutputStream(new FileOutputStream("./source/obj.dat"))){
            write.writeObject(p);
            write.writeObject(a);
        }
    }

    public static void readObjFromFile() throws Exception{
        try(ObjectInputStream read=new ObjectInputStream(new FileInputStream("./source/obj.dat"))){
            People p = (People) read.readObject();
            Animal a = (Animal) read.readObject();
            out.println(p.name);
        }
    }


    public static void main(String[] args) throws Exception {
//        write2File();
//        readFromFile();
//        writeObj2File();
        readObjFromFile();
    }

}

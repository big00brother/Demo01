package com.test;

import java.io.*;
import java.util.concurrent.ConcurrentHashMap;

public class SerializableTest {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        PersonDemo personDemo = new PersonDemo(1, "001", "张三");

        FileOutputStream fileOut = new FileOutputStream("D:\\file\\object.txt");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(personDemo);
        out.close();
        fileOut.close();
        System.out.println("Serialized data is saved in object.txt");


        FileInputStream fileIn = new FileInputStream("D:\\file\\object.txt");
        ObjectInputStream in = new ObjectInputStream(fileIn);
        PersonDemo obj = (PersonDemo) in.readObject();

        in.close();
        fileIn.close();
    }
}

package com.test;

import java.io.*;
import java.util.concurrent.ConcurrentHashMap;

public class CloneObjectTest {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("1", "1");

        CloneObject cloneObject = new CloneObject(concurrentHashMap);

        Object object = cloneObject.clone();

        System.out.println(object);

        FileOutputStream fileOut = new FileOutputStream("D:\\file\\object.txt");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(object);
        out.close();
        fileOut.close();
        System.out.println("Serialized data is saved in object.txt");


        FileInputStream fileIn = new FileInputStream("D:\\file\\object.txt");
        ObjectInputStream in = new ObjectInputStream(fileIn);
        CloneObject obj = (CloneObject) in.readObject();

        in.close();
        fileIn.close();
    }
}

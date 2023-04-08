package com.test;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

public class HashMapTest {

    public static void main(String[] args) throws IOException {

        HashMap<Integer, Integer> map = new HashMap<>(14);

        int cap = 1000;
        int n = cap - 1;
        System.out.println(n >>> 1);
        System.out.println(n >>> 2);
        System.out.println(n >>> 4);
        System.out.println(n >>> 8);
        System.out.println(n >>> 16);
        n |= n >>> 1;
        System.out.println("1次：" + n);
        n |= n >>> 2;
        System.out.println("2次：" + n);
        n |= n >>> 4;
        System.out.println("3次：" + n);
        n |= n >>> 8;
        System.out.println("4次：" + n);
        n |= n >>> 16;
        System.out.println("5次：" + n);

        String a = "123";
        String b = a;
        System.out.println(b == a);
        a = a + "123";
        System.out.println(b == a);

        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(""));

    }
}

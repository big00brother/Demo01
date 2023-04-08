package com.test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class HashTableTest {
    public static void main(String[] args) {
        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("1", "1");

        Hashtable<String, String> hashtable = new Hashtable<>();
        hashtable.put("1", "1");

        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("1", "1");
        hashMap.put("2", "2");

        short s = 1;
        s = (short) (s + s);
        System.out.println(s);
        s += s;
        System.out.println(s);

        Integer a = 2;
        Object b = (Object) (a);
        Person p = (Person) b;

        List<Integer> list = new ArrayList<Integer>(){
            {
                add(1);
                add(2);
                add(3);
            }
        };
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            iterator.next();
            list.add(4);
        }


    }
}

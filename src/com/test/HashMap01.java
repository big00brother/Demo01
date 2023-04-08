package com.test;

import java.util.ArrayList;

public class HashMap01 {

    private double defaultLoadFactor = 0.75;
    private int initSize = 16;

    private double loadFactor;

    private LinkNode[] arr;

    private int size;

    private int useSize;

    public HashMap01() {
        arr = new LinkNode[initSize];
        size = initSize;
        loadFactor = defaultLoadFactor;
        useSize = 0;
    }

    //扩容
    public void expandContainer() {

    }

    //计算hash
    public int hash(String key) {
        return key.hashCode() % size;
    }

//    public String get(String value) {
//
//    }

    public void put(String key, String value) {
        if(useSize >= size * loadFactor) {
            expandContainer();
        }

        int hash = hash(key);

        LinkNode node = arr[hash];

        if(node == null) {
            arr[hash] = new LinkNode(new Data(key, value), null);
            return ;
        }

        while(node != null) {
            if(node.dataNode.value.equals(value)) {

            }
        }


    }
}

class Data {
    public String key;

    public String value;

    public Data(String key, String value) {
        this.key = key;
        this.value = value;
    }
}

class LinkNode {
    public Data dataNode;

    public LinkNode next;

    public LinkNode(Data dataNode, LinkNode next) {
        this.dataNode = dataNode;
        this.next = next;
    }
}

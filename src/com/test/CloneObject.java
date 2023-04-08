package com.test;

import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;

public class CloneObject implements Cloneable, Serializable {

    private transient ConcurrentHashMap<String, String> map;

    public CloneObject(ConcurrentHashMap<String, String> map) {
        this.map = map;
    }

    public ConcurrentHashMap<String, String> getMap() {
        return map;
    }

    public void setMap(ConcurrentHashMap<String, String> map) {
        this.map = map;
    }

    public Object clone() {
        Object clone = null;
        try {
            clone = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }
}

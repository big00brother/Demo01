package com.test;

import java.util.ArrayList;
import java.util.List;

class Observer {

    private static Object object = new Object();

    private static List<Listener> listeners = new ArrayList<>();


    public void register(Listener listener) {
        synchronized (object) {
            listeners.add(listener);
        }
    }

    private int num;

    public void setNum(int num) {
        this.num = num;
        for(Listener listener : listeners) {
            listener.notifyChange(num);
        }
    }

}

class Listener {

    public void notifyChange(int num) {
        System.out.println("num value update, new value is " + num);
    }
}

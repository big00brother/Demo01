package com.test;

public class BeanDemo {

    public static void main(String[] args) {

        Object obj = new PersonBean();
        if(obj instanceof  PersonBean personBean) {
            personBean.name = "lvhao";
        }
        System.out.println(obj);
    }
}

class PersonBean {
    public String name;
}

package com.test;

public class Student extends Person{
    public Student(Integer age) {
        super(age);
    }

    @Override
    public Integer getAge() {
        return super.getAge();
    }

    public static void main(String[] args) {
        Person.main(args);
        System.out.println(1);
    }
}

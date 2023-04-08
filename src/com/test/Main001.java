package com.test;

public class Main001 {

    public static void main(String[] args) {
        Two one = new Two();
    }
}

class One {

    public One() {
        aa();
        bb();
    }

    private void aa() {
        System.out.println("aa one");
    }

    void bb() {
        System.out.println("bb one");
    }
}

class Two extends One{

    public void aa() {
        System.out.println("aa two");
    }

    public void bb() {
        System.out.println("bb two");
    }
}
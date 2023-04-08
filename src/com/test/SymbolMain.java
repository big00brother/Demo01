package com.test;

public class SymbolMain {

    public static void main(String[] args) {
        int n = 33;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        System.out.println(n);

        int m = -32;
        m = m >>> 1;
        System.out.println(m);

    }
}

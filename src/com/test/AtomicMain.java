package com.test;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

public class AtomicMain {

    public static void main(String[] args) {
        AtomicStampedReference atomicStampedReference = new AtomicStampedReference(100, 1);
        AtomicInteger atomicInteger = new AtomicInteger(0);
        System.out.println(atomicInteger.getAndSet(1));
        System.out.println(atomicInteger.get());
        System.out.println(atomicInteger.addAndGet(1));
        System.out.println(atomicInteger.get());
    }
}

package com.test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicMarkableReference;
import java.util.concurrent.atomic.AtomicStampedReference;

public class SolveABAByAtomicMarkableReference {

    private static AtomicStampedReference atomicStampedReference = new AtomicStampedReference(100, 1);

    private static AtomicMarkableReference atomicMarkableReference = new AtomicMarkableReference(100, false);

    public static void main(String[] args) {

        Thread refT1 = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("marked1 start :" +  atomicMarkableReference.isMarked());
            atomicMarkableReference.compareAndSet(100, 101, atomicMarkableReference.isMarked(), !atomicMarkableReference.isMarked());
            System.out.println("marked1 end:" +  atomicMarkableReference.isMarked());
            System.out.println("marked2 start :" +  atomicMarkableReference.isMarked());
            atomicMarkableReference.compareAndSet(101, 100, atomicMarkableReference.isMarked(), !atomicMarkableReference.isMarked());
            System.out.println("marked2 end :" +  atomicMarkableReference.isMarked());
        });

        Thread refT2 = new Thread(() -> {
            boolean marked = atomicMarkableReference.isMarked();
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("marked3 start :" +  atomicMarkableReference.isMarked());
            boolean c3 = atomicMarkableReference.compareAndSet(100, 101, marked, !marked);
            System.out.println("marked3 end :" +  atomicMarkableReference.isMarked());
            System.out.println(c3); // 返回true,实际应该返回false
        });

        Thread refT3 = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("marked1 start :" +  atomicStampedReference.getStamp());
            atomicStampedReference.compareAndSet(100, 101, atomicStampedReference.getStamp(), atomicStampedReference.getStamp() +1);
            System.out.println("marked1 end:" +  atomicStampedReference.getStamp());
            System.out.println("marked2 start :" +  atomicStampedReference.getStamp());
            atomicStampedReference.compareAndSet(101, 100, atomicStampedReference.getStamp(), atomicStampedReference.getStamp() +1);
            System.out.println("marked2 end :" +  atomicStampedReference.getStamp());
        });

        Thread refT4 = new Thread(() -> {
            int stamp = atomicStampedReference.getStamp();
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("marked3 start :" +  atomicStampedReference.getStamp());
            boolean c3 = atomicStampedReference.compareAndSet(100, 101, stamp, stamp + 1);
            System.out.println("marked3 end :" +  atomicStampedReference.getStamp());
            System.out.println(c3); // 返回true,实际应该返回false
        });

//        refT1.start();
//        refT2.start();

        refT3.start();
        refT4.start();
    }

}

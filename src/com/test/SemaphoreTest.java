package com.test;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreTest {

    private static Semaphore semaphore = new Semaphore(2);

    public static void main(String[] args) {
        // 表示有2个许可.
        Semaphore sem = new Semaphore(2);
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                try {
                    // 默认使用一个许可.
                    sem.acquire();
                    System.out.println(Thread.currentThread() + " I get it.");
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println(Thread.currentThread() + " I release it.");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    sem.release();
                }
            }).start();
        }
    }

}

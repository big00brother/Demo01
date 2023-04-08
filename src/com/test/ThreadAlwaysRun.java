package com.test;

import java.util.concurrent.Semaphore;

public class ThreadAlwaysRun {

    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(1);

        for(int i = 0; i < 5; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    int count = 0;
                    while (true) {
                        for(int i = 0; i < 1000000; i++) {
                            count += i;
                        }
                    }
                }
            });
            thread.start();
        }

        for(int i = 0; i < 5; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        semaphore.acquire();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
            thread.start();
        }

    }
}

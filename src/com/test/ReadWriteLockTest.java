package com.test;

import java.util.UUID;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockTest {

    public static void readCache() {
        MyCache cache = new MyCache();
        for (int i = 0; i < 5; i++) {
            String key = String.valueOf(i+1);
            new Thread(()->{
                try {
                    cache.get(key);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },"read-"+key).start();
        }
    }

    public static void writeCache() {
        MyCache cache=new MyCache();
        for (int i = 0; i < 5; i++) {
            String key = String.valueOf(i + 1);
            new Thread(() -> {
                String str = UUID.randomUUID().toString();
                try {
                    cache.put(key, str.substring(4, 10));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, "wirte-" + key).start();
        }
    }

    //写锁降为读锁
    public static void lockDownGrade() {
        //读写锁
        final ReadWriteLock rwLock = new ReentrantReadWriteLock();
        //获取写锁
        final Lock wLock = rwLock.writeLock();
        //获取读锁
        final Lock rLock = rwLock.readLock();
        //加锁
        wLock.lock();
        System.out.println("写锁开始工作");
        rLock.lock();
        System.out.println("读锁开始工作");
        wLock.unlock();
        rLock.unlock();
    }

    //读锁不能升级为写锁
    public static void lockUpGradeFailed() {
        //读写锁
        final ReadWriteLock rwLock = new ReentrantReadWriteLock();
        //获取写锁
        final Lock wLock = rwLock.writeLock();
        //获取读锁
        final Lock rLock = rwLock.readLock();
        //加锁

        rLock.lock();
        System.out.println("读锁开始工作");
        wLock.lock();
        System.out.println("写锁开始工作");
        rLock.unlock();
        wLock.unlock();
    }

    public static void main(String[] args) {
        lockUpGradeFailed();
    }
}

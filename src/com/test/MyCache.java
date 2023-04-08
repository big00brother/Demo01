package com.test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

//定义缓存
public class MyCache {
    private volatile Map<String, Object> cache = new HashMap<>();
    //读写锁
    private final ReadWriteLock rwLock = new ReentrantReadWriteLock();
    //获取写锁
    private final Lock wLock = rwLock.writeLock();
    //获取读锁
    private final Lock rLock = rwLock.readLock();

    // 写数据
    public void put(String key, Object value) throws InterruptedException {
        //加锁
        wLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + ",写入数据：" + key);
            TimeUnit.SECONDS.sleep(2);
            cache.put(key, value);
            System.out.println(Thread.currentThread().getName() + ",写入数据完成：" + key);
        } finally {
            //释放锁
            wLock.unlock();
        }
    }
    //读数据
    public Object get(String key) throws InterruptedException {
        Object res = cache.get(key);
        //加锁
        rLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + ",读数据：" + key);
            TimeUnit.SECONDS.sleep(2);
            System.out.println(Thread.currentThread().getName() + ",读数据完成：" + key);
        } finally {
            //释放锁
            rLock.unlock();
            return res;
        }
    }

}

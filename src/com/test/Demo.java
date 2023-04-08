package com.test;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.*;

public class Demo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Executors.newCachedThreadPool();
        Executors.newFixedThreadPool(5);
        Executors.newScheduledThreadPool(6);

        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("133", "223");
        concurrentHashMap.put("1333", "223");
        concurrentHashMap.put("1331", "223");

        Set<Map.Entry<String, String>> entrySet = concurrentHashMap.entrySet();
        for(Map.Entry<String, String> entry : entrySet) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(4, 6, 10L, TimeUnit.SECONDS, new ArrayBlockingQueue<>(5));
        for (int i = 0; i < 5; i++) {
            int finalI = i;
            threadPoolExecutor.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("线程" + finalI + "开始");
                    int total = 0;
                    for(int i = 0; i < 1000000; i++) {
                        total += i;
                    }
                    Thread thread = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            int total = 0;
                            for(int i = 0; i < 1000000; i++) {
                                total += i;
                            }
                            System.out.println("里面线程执行完：" + total);
                        }
                    });
                    thread.start();
                    System.out.println(total);
                }
            }).get();
        }



        System.out.println("finish");

    }
}

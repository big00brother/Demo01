package com.test;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask task = new FutureTask(new MyCallable());

        Thread thread = new Thread(task);

        thread.start();

        System.out.println(task.get());

        System.out.println("finish");

    }

}


class MyCallable implements Callable<Integer> {


    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName()+",正在执行!");
        int sum = 0;
        for(int i = 0 ; i <10000 ; i++){
            sum+=i;
        }
        System.out.println("线程执行结束：" + sum);
        return sum;
    }
}


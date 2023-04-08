package com.test.queue;


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayQueueTest {

    public static void main(String[] args) throws Exception {
        BlockingQueue<Task> delayQueue = new DelayQueue<>();
        long now = System.currentTimeMillis();
        delayQueue.put(new Task(now+3000));
        delayQueue.put(new Task(now+4000));
        delayQueue.put(new Task(now+6000));
        delayQueue.put(new Task(now+1000));
        System.out.println(delayQueue);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while(true) {
                        Task task = delayQueue.take();
                        System.out.println(Thread.currentThread().getName() + "到达截止时间:" + task);
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        });

        thread.start();

    }

    static class Task implements Delayed{
        long time = System.currentTimeMillis();
        public Task(long time) {
            this.time = time;
        }
        @Override
        public int compareTo(Delayed o) {
            if(this.getDelay(TimeUnit.MILLISECONDS) < o.getDelay(TimeUnit.MILLISECONDS))
                return -1;
            else if(this.getDelay(TimeUnit.MILLISECONDS) > o.getDelay(TimeUnit.MILLISECONDS))
                return 1;
            else
                return 0;
        }

        @Override
        public long getDelay(TimeUnit unit) {
            return unit.convert(time - System.currentTimeMillis(),  TimeUnit.MILLISECONDS);
        }
        @Override
        public String toString() {
            return "" + time;
        }
    }
}

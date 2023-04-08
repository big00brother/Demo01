package com.test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

public class TheadPrint {

    public static volatile boolean flag = true;

    public static Lock unFairLock = new ReentrantLock();

    public static Condition unFairLockCondition = unFairLock.newCondition();

    public static Lock fairLock = new ReentrantLock(true);

    public static Condition fairCondition = fairLock.newCondition();

    public static Object obj = new Object();

    public static Semaphore semaphoreA = new Semaphore(1, true);

    public static Semaphore semaphoreB = new Semaphore(0, true);

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 100; i += 2) {
                    while(!flag) {

                    }
                    System.out.println(i);
                    flag = false;
                }
            }
        });

        Thread thread2 = new Thread((new Runnable() {
            @Override
            public void run() {
                for(int i = 1; i < 100; i += 2) {
                    while(flag) {

                    }
                    System.out.println(i);
                    flag = true;
                }
            }
        }));


        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 100; i += 2) {
                    unFairLock.lock();
                    System.out.println(i);
                    try {
                        unFairLockCondition.signal();
                        if( i != 98) {
                            unFairLockCondition.await();
                        }
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    } finally {
                        unFairLock.unlock();
                    }

                }
            }
        });

        Thread thread4 = new Thread((new Runnable() {
            @Override
            public void run() {
                for(int i = 1; i < 100; i += 2) {
                    unFairLock.lock();
                    System.out.println(i);
                    try {
                        unFairLockCondition.signal();
                        if( i != 99) {
                            unFairLockCondition.await();
                        }
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    } finally {
                        unFairLock.unlock();
                    }
                }
            }
        }));

        Thread thread5 = new Thread((new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 100; i += 2) {
                    synchronized (obj) {
                        System.out.println(i);
                        obj.notify();
                        try {
                            if( i != 98) {
                                obj.wait();
                            }
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        }));


        Thread thread6 = new Thread((new Runnable() {
            @Override
            public void run() {
                for(int i = 1; i < 100; i += 2) {
                    synchronized (obj) {
                        System.out.println(i);
                        obj.notify();
                        try {
                            if( i != 99) {
                                obj.wait();
                            }
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        }));

        Thread thread7 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 100; i += 2) {
                    fairLock.lock();
                    System.out.println(i);
                    try {
                        fairCondition.signal();
                        if( i != 98) {
                            fairCondition.await();
                        }
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    } finally {
                        fairLock.unlock();
                    }

                }
            }
        });

        Thread thread8 = new Thread((new Runnable() {
            @Override
            public void run() {
                for(int i = 1; i < 100; i += 2) {
                    fairLock.lock();
                    System.out.println(i);
                    try {
                        fairCondition.signal();
                        if( i != 99) {
                            fairCondition.await();
                        }
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    } finally {
                        fairLock.unlock();
                    }
                }
            }
        }));



        Thread thread9 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 100; i += 2) {
                    fairLock.lock();
                    System.out.println(i);
                    fairLock.unlock();
                }
            }
        });

        Thread thread10 = new Thread((new Runnable() {
            @Override
            public void run() {
                for(int i = 1; i < 100; i += 2) {
                    fairLock.lock();
                    System.out.println(i);
                    fairLock.unlock();
                }
            }
        }));


        Thread thread11 = new Thread((new Runnable() {
            @Override
            public void run() {
                for(int i = 100; i < 200; i += 2) {
                    fairLock.lock();
                    System.out.println(i);
                    fairLock.unlock();
                }
            }
        }));

        Thread thread12 = new Thread((new Runnable() {
            @Override
            public void run() {
                for(int i = 101; i < 200; i += 2) {
                    fairLock.lock();
                    System.out.println(i);
                    fairLock.unlock();
                }
            }
        }));


        Thread thread13 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 100; i += 2) {
                    try {
                        semaphoreA.acquire();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(i);
                    semaphoreB.release();
                }
            }
        });

        Thread thread14 = new Thread((new Runnable() {
            @Override
            public void run() {
                for(int i = 1; i < 100; i += 2) {
                    try {
                        semaphoreB.acquire();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(i);
                    semaphoreA.release();
                }
            }
        }));

        thread13.start();
        thread14.start();

    }



}

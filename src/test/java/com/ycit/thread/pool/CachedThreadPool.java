package com.ycit.thread.pool;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池
 *
 * @author xlch
 * @Date 2017-12-08 11:05
 */
public class CachedThreadPool {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        ExecutorService executor = Executors.newCachedThreadPool();
        Object object = new Object();
        for (int i = 1; i <= 4; i++) {
            final int index = i;
            executor.execute(() -> {
//                System.out.println("current thread name is ====" + Thread.currentThread().getName());
                System.out.println("execute sort is :" + index);
                try {
//                    synchronized (object) {
                    if (index % 2 == 0) {
                        Thread.sleep(20000);
                    }
//                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("index is " + index);
            });
        }
        executor.shutdown();
        System.out.println("time is ===" + (System.currentTimeMillis() - startTime));
    }

}

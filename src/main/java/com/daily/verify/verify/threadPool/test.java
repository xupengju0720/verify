package com.daily.verify.verify.threadPool;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池的一种使用
 */
public class test {
    public static void main(String[] args) {
        List<Integer> listInt = new ArrayList<>();
        for (int i = 0; i < 101; i++) {
            listInt.add(i);
        }
        verify(listInt);
    }

    public static void verify(List<Integer> listInt) {
        List<List<Integer>> listResponse = Lists.partition(listInt, listInt.size() / (15 * (listInt.size() / 150 + 1)) + 1);
        /*创建指定数量的线程池*/
        ExecutorService executorService = Executors.newFixedThreadPool(listResponse.size());
        //创建线程等待的计数器
        final CountDownLatch countdown = new CountDownLatch(listResponse.size());
        List<Integer> multiThreadList = Collections.synchronizedList(new ArrayList<>());
        try {
            listResponse.forEach(x -> {
                //执行主要内容
                executorService.execute(() -> {
                    System.out.println("当前线程：" + Thread.currentThread().getName());
                    try {
                        multiThreadList.addAll(adivision(x));
                    } catch (RuntimeException e) {
                        e.printStackTrace();
                    }
                    //每条线程执行完成后计数器减一
                    countdown.countDown();
                    System.err.println("当前计数器值为:" + countdown.getCount());
                });
            });
            countdown.await();
            System.out.println("主线程执行");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            executorService.shutdown();
        }
    }

    private static Collection<? extends Integer> adivision(List<Integer> x) {
        for (Integer t : x) {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
            }
            int count = 10 / t;
        }
        return x;
    }
}

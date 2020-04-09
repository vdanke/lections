package org.step.fourth.test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Runner {

    public static void main(String[] args) throws Exception {
        GetPerformance getPerformance = new GetPerformance();
        CountDownLatch countDownLatch = new CountDownLatch(1);

        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<Long> first = executorService.submit(new Make(
                0,
                500000,
                getPerformance.getSyncMap(),
                countDownLatch));
        Future<Long> second = executorService.submit(new Make(
                500001,
                1000000,
                getPerformance.getSyncMap(),
                countDownLatch));

        countDownLatch.countDown();

        System.out.println((first.get() + second.get()) / 1000);

        if (!executorService.isShutdown()) {
            executorService.shutdown();
        }
    }
}

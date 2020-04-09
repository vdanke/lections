package org.step.fourth.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;

public class Solution {

    public static void main(String[] args) throws Exception {
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);

        Future<String> submit = cachedThreadPool.submit(new CallableThread());

        System.out.println(submit.get());

        cachedThreadPool.execute(new SimpleThread());
        cachedThreadPool.execute(new SimpleThread());

        Future<StringBuffer> submit1 = cachedThreadPool.submit(new SimpleThread(), new StringBuffer(""));

        boolean shutdown = cachedThreadPool.isShutdown();

        if (!shutdown) {
            cachedThreadPool.shutdown();
        }
    }
}

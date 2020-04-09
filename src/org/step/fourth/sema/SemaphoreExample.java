package org.step.fourth.sema;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class SemaphoreExample {

    public static void main(String[] args) throws InterruptedException {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        AtomicBoolean atomicBoolean = new AtomicBoolean(true);

        Semaphore semaphore = new Semaphore(2);
        CountDownLatch countDownLatch = new CountDownLatch(2);
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    semaphore.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Callable<String> stringCallable = () -> {
            semaphore.acquire();
            semaphore.release();
            return "";
        };

        if (countDownLatch.getCount() == 0) {
            countDownLatch = new CountDownLatch(2);
        }
        if (cyclicBarrier.isBroken()) {
            cyclicBarrier.reset();
        }
    }
}

package org.step.fourth.test;

import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

public class Make implements Callable<Long> {

    private int from;
    private int to;
    private Map<Integer, String> integerStringMap;
    private CountDownLatch countDownLatch;

    public Make(int from, int to, Map<Integer, String> integerStringMap, CountDownLatch countDownLatch) {
        this.from = from;
        this.to = to;
        this.integerStringMap = integerStringMap;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public Long call() throws Exception {
        countDownLatch.await();

        long l = System.nanoTime();
        for (int i = from; i < to; i++) {
            integerStringMap.get(i);
            if (i % 4 == 0) {
                integerStringMap.put(i, " + ");
            }
        }
        return System.nanoTime() - l;
    }
}

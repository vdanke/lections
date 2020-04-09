package org.step.fourth.executors;

public class SimpleThread implements Runnable {

    private int count = 0;

    @Override
    public void run() {
        for (int i = 0; i < 1000000000; i++) {
            count++;
        }
        System.out.println(count);
    }
}

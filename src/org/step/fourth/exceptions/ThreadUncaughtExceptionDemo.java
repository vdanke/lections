package org.step.fourth.exceptions;

public class ThreadUncaughtExceptionDemo {

    public static void main(String[] args) {
        Thread t = new Thread(new SimpleThread());
        t.setUncaughtExceptionHandler(
                new Thread.UncaughtExceptionHandler() {
                    public void uncaughtException(Thread t, Throwable e) {
                        System.out.println(t + " throws exception: " + e);
                    }
                });
        t.start();
    }

    static class SimpleThread implements Runnable {
        public void run() {
            throw new RuntimeException("It is a great exception.");
        }
    }
}




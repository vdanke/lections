package org.step.fourth.exceptions;

public class ThreadGroupUncaughtExceptionDemo {

    public static void main(String[] args) {
        NewThreadGroup g = new NewThreadGroup("one");

        ThreadD t1 = new ThreadD("1", g);
        ThreadD t2 = new ThreadD("2", g);
        ThreadD t3 = new ThreadD("3", g);

        t3.setUncaughtExceptionHandler(
                new Thread.UncaughtExceptionHandler() {
                        	public void uncaughtException(Thread t, Throwable e) {
                        System.out.println(t + " throws exception: " + e);
                    }
                });

        t1.start();
        t2.start();
        t3.start();
    }

    static class NewThreadGroup extends ThreadGroup {

        NewThreadGroup(String n) {
            super(n);
        }

        NewThreadGroup(ThreadGroup parent, String n) {
            super(parent, n);
        }

        public void uncaughtException(Thread t, Throwable e) {
            System.out.println(t + " has unhandled exception:" + e);
        }
    }

    static class ThreadD extends Thread {

        public ThreadD(String threadName, ThreadGroup tgOb) {
            super(tgOb, threadName);
        }

        public void run() {
            throw new RuntimeException("Oy, exception!!!");
        }
    }
}



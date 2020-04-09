package org.step.fourth.join;

public class NewThread implements Runnable {

    private String threadName;
    private Thread thread;

    public NewThread() {
    }

    public NewThread(String threadName) {
        this.threadName = threadName;
        thread = new Thread(this, threadName);
        thread.start();
    }

    public void run() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println(threadName + ": " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println(threadName + " interrupted.");
        }
        System.out.println(threadName + " exiting.");
    }

    public String getThreadName() {
        return threadName;
    }

    public Thread getThread() {
        return thread;
    }
}

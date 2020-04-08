package org.step.fourth.demons;

public class DaemonInspector {

    public static void main(String[] args) {
        System.out.println("Start main thread");

        DaemonThread daemonThread = new DaemonThread();

        daemonThread.setDaemon(true);
        daemonThread.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("End main thread");
    }
}

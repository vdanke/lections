package org.step.fourth.priority;

public class PriorityDemo {

    public static void main(String[] args) {
        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);

        Clicker first = new Clicker();
        Clicker second = new Clicker();

        first.setPriority(Thread.NORM_PRIORITY + 2);
        second.setPriority(Thread.NORM_PRIORITY - 2);

        first.start();
        second.start();

        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }

        first.stopClick();
        second.stopClick();

        try {
            first.join();
            second.join();
        } catch (InterruptedException e) {
            System.out.println("Interrupted exception caught");
        }
        System.out.println("Low-priority thread: " + second.getClick());
        System.out.println("High-priority thread: " + first.getClick());
    }
}

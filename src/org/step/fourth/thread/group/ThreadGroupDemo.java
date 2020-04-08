package org.step.fourth.thread.group;

public class ThreadGroupDemo {

    public static void main(String[] args) {

        ThreadGroup groupA = new ThreadGroup("Group A");
        ThreadGroup groupB = new ThreadGroup("Group B");

        MyThread ob1 = new MyThread("One", groupA);
        MyThread ob2 = new MyThread("Two", groupA);
        MyThread ob3 = new MyThread("Three", groupB);
        MyThread ob4 = new MyThread("Four", groupB);

        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        groupA.interrupt();
    }
}


package org.step.fourth.join;

public class DemoJoin {

    public static void main(String[] args) {
        NewThread ob1 = new NewThread("One");
        NewThread ob2 = new NewThread("Two");
        NewThread ob3 = new NewThread("Three");

        System.out.println("Thread One is alive: " + ob1.getThread().isAlive());
        System.out.println("Thread Two is alive: " + ob2.getThread().isAlive());
        System.out.println("Thread Three is alive: " + ob3.getThread().isAlive());

        try {
            System.out.println("Waiting for threads to finish.");
            ob1.getThread().join();
            ob2.getThread().join();
            ob3.getThread().join();
        } catch (InterruptedException e) {
            System.out.println("Main thread Interrupted");
        }
        System.out.println("Thread One is alive: " + ob1.getThread().isAlive());
        System.out.println("Thread Two is alive: " + ob2.getThread().isAlive());
        System.out.println("Thread Three is alive: " + ob3.getThread().isAlive());
        System.out.println("Main thread exiting.");
    }

}

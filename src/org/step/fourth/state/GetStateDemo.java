package org.step.fourth.state;

public class GetStateDemo implements Runnable{

    @Override
    public void run() {
        Thread.State state = Thread.currentThread().getState();
        System.out.println(Thread.currentThread().getName() + " " + state);
    }

    public static void main(String[] args) {
        Thread th1 = new Thread(new GetStateDemo());
        th1.start();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        Thread.State state = th1.getState();
        System.out.println(th1.getName() + " " + state);
    }
}


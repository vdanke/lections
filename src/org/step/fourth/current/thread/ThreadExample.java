package org.step.fourth.current.thread;

public class ThreadExample {

    public static void main(String[] args) {
        ThreadExample threadExample = new ThreadExample();

        threadExample.currentThread();
    }

    public void currentThread() {
        Thread current = Thread.currentThread();
        System.out.println("Текущий поток: " + current);

        current.setName("My thread");
        current.setPriority(Thread.MAX_PRIORITY);

        System.out.println("Поток после изменения имени: " + current);

        try {
            for (int n = 5; n > 0; n--) {
                System.out.println(n);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

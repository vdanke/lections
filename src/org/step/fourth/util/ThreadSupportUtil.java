package org.step.fourth.util;

public class ThreadSupportUtil {

    public static void cycleThreadRunner(String active, int sleep) {
        for (int i = 0; i < 8; i++) {
            System.out.println(active);
            try {
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

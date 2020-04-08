package org.step.fourth.demons;

import org.step.fourth.util.ThreadSupportUtil;

public class DaemonThread extends Thread {

    @Override
    public void run() {
        ThreadSupportUtil.cycleThreadRunner("Demon is running", 1000);
    }
}

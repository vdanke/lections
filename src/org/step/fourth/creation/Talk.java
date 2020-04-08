package org.step.fourth.creation;

import org.step.fourth.util.ThreadSupportUtil;

public class Talk extends Thread {

    @Override
    public void run() {
        ThreadSupportUtil.cycleThreadRunner("Talking", 400);
    }
}

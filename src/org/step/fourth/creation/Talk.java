package org.step.fourth.creation;

import org.step.fourth.util.ThreadSupportUtil;

public class Talk extends Thread {

    @Override
    public void run() {
        new ThreadSupportUtil().cycleThreadRunner("Talking", 400);
    }
}

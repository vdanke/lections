package org.step.fourth.creation;

import org.step.fourth.util.ThreadSupportUtil;

public class Walk implements Runnable {

    @Override
    public void run() {
        ThreadSupportUtil.cycleThreadRunner("Walking", 400);
    }
}

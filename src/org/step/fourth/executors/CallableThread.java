package org.step.fourth.executors;

import org.step.fourth.util.ThreadSupportUtil;

import java.util.concurrent.Callable;

public class CallableThread implements Callable<String> {

    @Override
    public String call() throws Exception {
        new ThreadSupportUtil().cycleThreadRunner("I'am callable", 500);

        return "Finished";
    }
}

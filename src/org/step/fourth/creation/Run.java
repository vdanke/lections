package org.step.fourth.creation;

import java.util.concurrent.Callable;

public class Run implements Callable<String> {

    @Override
    public String call() throws Exception {
        return "I'am running";
    }
}

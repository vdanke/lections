package org.step.fourth.wait.notify;

public class Runner {

    public static void main(String[] args) {
        IntegerSetterGetter integerSetterGetter = new IntegerSetterGetter("Thread", new SharedResource());
        integerSetterGetter.run();
    }
}

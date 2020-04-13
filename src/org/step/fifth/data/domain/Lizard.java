package org.step.fifth.data.domain;

public class Lizard extends Animal {

    @Override
    public void eat() {
        Thread t = new Thread(super::eat);
        t.start();
    }
}

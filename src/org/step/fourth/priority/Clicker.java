package org.step.fourth.priority;

public class Clicker extends Thread {

    private int click = 0;
    private volatile boolean running = true;

    public Clicker() {
    }

    public void stopClick() {
        running = false;
    }

    @Override
    public void run() {
        while (running) {
            click++;
        }
    }

    public int getClick() {
        return click;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }
}

package org.step.fourth.collection.threadsafe;

import java.util.Random;

class Task implements Comparable<Task> {
    private int taskNumber;

    public Task() {
    }

    public Task(int num) {
        taskNumber = num;
    }

    public int getTaskNumber() {
        return taskNumber;
    }

    public void setTaskNumber(int taskNumber) {
        this.taskNumber = taskNumber;
    }

    @Override
    public int compareTo(Task o) {
        Random rand = new Random();
        int comp = rand.nextInt(2000);
        if (comp % 2 == 0) return 1;
        if (comp % 3 == 0) return -1;
        else return 0;
    }
}


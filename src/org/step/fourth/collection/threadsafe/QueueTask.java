package org.step.fourth.collection.threadsafe;

import java.util.concurrent.PriorityBlockingQueue;

public class QueueTask{
    private PriorityBlockingQueue<Task> queue = new PriorityBlockingQueue<>();

    public Task getTask() {
        return queue.poll();
    }

    public void setTask(Task task) {
        queue.add(task);
    }

    public PriorityBlockingQueue<Task> getQueue() {
        return queue;
    }
}


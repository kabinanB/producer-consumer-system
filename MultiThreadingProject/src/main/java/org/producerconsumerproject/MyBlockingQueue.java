package org.producerconsumerproject;


import java.util.LinkedList;
import java.util.Queue;

public class MyBlockingQueue<T> {

    private final Queue<T> queue = new LinkedList<>();
    private final int capacity;

    public MyBlockingQueue(int capacity) {
        this.capacity = capacity;
    }

    public synchronized void put(T item) throws InterruptedException {
        while (queue.size() == capacity) {
            wait();  // wait until space becomes available
        }

        // If queue was empty before adding, notify consumers
        if (queue.isEmpty()) {
            notifyAll();
        }

        queue.add(item);
    }

    public synchronized T take() throws InterruptedException {
        while (queue.isEmpty()) {
            wait(); // wait until an item becomes available
        }

        // If queue was full before removing, notify producers
        if (queue.size() == capacity) {
            notifyAll();
        }

        return queue.remove();
    }
}

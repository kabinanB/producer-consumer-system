package org.producerconsumerproject;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{
    private final BlockingQueue<String> queue;
    private final int id;

    public Consumer(BlockingQueue<String> queue, int id) {
        this.queue = queue;
        this.id = id;
    }

    @Override
    public void run() {
        try {
            while (true) {
                // take() waits if queue is empty
                String task = queue.take();

                System.out.println("Consumer " + id + " consumed: " + task);

                Thread.sleep(500); // simulate processing time
            }
        } catch (InterruptedException e) {
            System.out.println("Consumer " + id + " was interrupted.");
            Thread.currentThread().interrupt();
        }
    }
}

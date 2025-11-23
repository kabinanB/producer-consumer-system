package org.producerconsumerproject;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;

public class CallableConsumer implements Callable<Integer> {

    private final BlockingQueue<String> queue;

    public CallableConsumer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public Integer call() {
        int processedCount = 0;

        try {
            while (!Thread.currentThread().isInterrupted()) {

                // take() can throw InterruptedException
                String task = queue.take();

                System.out.println("CallableConsumer consumed: " + task);
                processedCount++;

                // sleep can ALSO throw InterruptedException
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt(); // restore flag
                    break; // exit loop safely
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        return processedCount;
    }
}

package org.producerconsumerproject;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

    private final BlockingQueue<String> queue;
    private final int id;

    public Producer(BlockingQueue<String> queue, int id) {
        this.queue = queue;
        this.id = id;
    }

    @Override
    public void run() {

        try{
            for(int i=1; i<=10; ++i){
                String task = "Task-" + id + "-" + i;
                System.out.println("Producer " + id + " produced: " + task);

                queue.put(task);

                Thread.sleep(300);
            }
        } catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }

    }
}

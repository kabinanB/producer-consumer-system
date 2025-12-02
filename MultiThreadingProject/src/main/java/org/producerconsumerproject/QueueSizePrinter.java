package org.producerconsumerproject;


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class QueueSizePrinter {

    public static void start(BlockingQueue<String> queue) {

        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        scheduler.scheduleAtFixedRate(() -> {
            System.out.println("[Scheduler] Queue size: " + queue.size());
        }, 0, 1, TimeUnit.SECONDS);
    }
}


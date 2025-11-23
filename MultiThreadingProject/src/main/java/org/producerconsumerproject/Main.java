package org.producerconsumerproject;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() throws InterruptedException {
//        System.out.println("Starting Producer-Consumer System...");
//
//
//        Thread thread = new Thread(()->{
//            System.out.println("Hello from a separate thread!");
//        });
//
//        thread.start();
//
//        System.out.println("Hello from the main thread!");
//

//        BlockingQueue<String> queue = new LinkedBlockingQueue<>(5);
//
//
//        Thread producer = new Thread(new Producer(queue, 1));
//        producer.start();
//
//        System.out.println("Producer started...");

//        System.out.println("Starting Producer–Consumer System...");
//
//        BlockingQueue<String> queue = new LinkedBlockingQueue<>(5);
//
//        Thread producer = new Thread(new Producer(queue, 1));
//        Thread consumer = new Thread(new Consumer(queue, 1));
//
//        producer.start();
//        consumer.start();
//
//        producer.join(); // wait for producer to finish
//
//        consumer.interrupt(); // stop consumer gracefully
//
//        System.out.println("Program finished.");


        System.out.println("Starting Producer–Consumer System...");

        BlockingQueue<String> queue = new LinkedBlockingQueue<>(5);

        Thread producer1 = new Thread(new Producer(queue, 1));
        Thread producer2 = new Thread(new Producer(queue, 2));

        Thread consumer1 = new Thread(new Consumer(queue, 1));
        Thread consumer2 = new Thread(new Consumer(queue, 2));

        producer1.start();
        producer2.start();

        consumer1.start();
        consumer2.start();

        // Wait for producers to finish
        producer1.join();
        producer2.join();

        // Stop consumers
        consumer1.interrupt();
        consumer2.interrupt();

        System.out.println("System finished.");

    }
}

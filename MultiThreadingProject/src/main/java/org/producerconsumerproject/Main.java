package org.producerconsumerproject;

import java.util.concurrent.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception{
        /*
        Lesson 1
         */
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

                /*
        Lesson 2
         */
//        BlockingQueue<String> queue = new LinkedBlockingQueue<>(5);
//
//
//        Thread producer = new Thread(new Producer(queue, 1));
//        producer.start();
//
//        System.out.println("Producer started...");

                /*
        Lesson 3
         */
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

                /*
        Lesson 4
         */

//        System.out.println("Starting Producer–Consumer System...");
//
//        BlockingQueue<String> queue = new LinkedBlockingQueue<>(5);
//
//        Thread producer1 = new Thread(new Producer(queue, 1));
//        Thread producer2 = new Thread(new Producer(queue, 2));
//
//        Thread consumer1 = new Thread(new Consumer(queue, 1));
//        Thread consumer2 = new Thread(new Consumer(queue, 2));
//
//        producer1.start();
//        producer2.start();
//
//        consumer1.start();
//        consumer2.start();
//
//        // Wait for producers to finish
//        producer1.join();
//        producer2.join();
//
//        // Stop consumers
//        consumer1.interrupt();
//        consumer2.interrupt();
//
//        System.out.println("System finished.");

                /*
        Lesson 5: Thread Pool
         */

//        System.out.println("Starting Producer-Consumer System...");
//
//        BlockingQueue<String> queue = new LinkedBlockingQueue<>(5);
//
//
//        ExecutorService executor = Executors.newFixedThreadPool(4);
//
//        executor.execute(new Producer(queue, 1));
//        executor.execute(new Producer(queue, 2));
//
//        executor.execute(new Consumer(queue, 1));
//        executor.execute(new Consumer(queue, 2));
//
//        //Wait for producers to finish
//        Thread.sleep(4000);
//
//        //Shut down consumers
//        executor.shutdownNow();
//
//        System.out.println("System finished.");

        /*
        Lesson 6: Callable and Future & Lesson 7: Daemon Threads
         */

        System.out.println("Starting Producer-Consumer System with Callable...");

        BlockingQueue<String> queue = new LinkedBlockingQueue<>(5);


        ExecutorService executor = Executors.newFixedThreadPool(4);


        //Daemon thread
        DaemonMonitor.start();
        // Producers
        executor.execute(new Producer(queue, 1));
        executor.execute(new Producer(queue, 2));


        //Callable Consumer
        Future<Integer> result = executor.submit(new CallableConsumer(queue));

        Thread.sleep(4000); // let system run

        executor.shutdownNow(); // stops consumer

        // Get the result from the Callable
        int tasksProcessed = result.get();

        System.out.println("CallableConsumer processed: " + tasksProcessed + " tasks");
        System.out.println("System finished.");
    }
}

# Producer–Consumer System (Java Multithreading)

This is a simple Java project demonstrating the classic **Producer–Consumer pattern** using multithreading.

The project shows how multiple producer threads generate tasks while multiple consumer threads process them in parallel. A shared queue is used to safely exchange data between threads.

## What It Demonstrates
- Creating and running threads
- Using `BlockingQueue` for thread-safe communication
- Producer threads adding tasks
- Consumer threads processing tasks
- Basic thread coordination

## Technologies
- Java Threads
- Runnable interface
- BlockingQueue (`LinkedBlockingQueue`)
- ExecutorService (thread pool)

## How to Run
Compile and run:

```bash
javac Main.java
java Main

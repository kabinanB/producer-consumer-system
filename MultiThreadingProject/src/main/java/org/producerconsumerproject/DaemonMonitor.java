package org.producerconsumerproject;

public class DaemonMonitor {

    public static void start() {
        Thread monitor = new Thread(() -> {
            while(true) {
                System.out.println("[Daemon] System is running...");
                try{
                    Thread.sleep(1000);
                } catch(InterruptedException e) {
                    break;
                }
            }
        });

        monitor.setDaemon(true);
        monitor.start();
    }
}

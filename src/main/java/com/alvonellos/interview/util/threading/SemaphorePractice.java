package com.alvonellos.interview.util.threading;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class SemaphorePractice {
    public static void main(String[] args) {
        // Create a semaphore with a maximum of 3 permits.
        Semaphore semaphore = new Semaphore(3);
        AtomicInteger num = new AtomicInteger(1);
        // Create a thread that will acquire a permit and then release it.
        Thread thread1 = new Thread(() -> {
            try {
                semaphore.acquire();
                System.out.println("Thread 1 acquired a permit.");
                Thread.sleep(1000);
                num.getAndIncrement();
                semaphore.release();
                System.out.println("Thread 1 released a permit.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        // Create a thread that will acquire a permit and then release it.
        Thread thread2 = new Thread(() -> {
            try {
                semaphore.acquire();
                System.out.println("Thread 2 acquired a permit.");
                Thread.sleep(1000);
                num.getAndIncrement();
                semaphore.release();
                System.out.println("Thread 2 released a permit.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        // Create a thread that will acquire a permit and then release it.
        Thread thread3 = new Thread(() -> {
            try {
                semaphore.acquire();
                System.out.println("Thread 3 acquired a permit.");
                Thread.sleep(1000);
                num.getAndIncrement();
                semaphore.release();
                System.out.println("Thread 3 released a permit.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("Thread 3 is done.");
                System.err.println("num: " + num.get());
            }
        });
        // Start the threads.
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
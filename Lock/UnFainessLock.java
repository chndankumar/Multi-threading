package Mutithreading.Lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class UnFainessLock {
    private final Lock unFarenessLock = new ReentrantLock();

    public void acessResource() {
        unFarenessLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " acquired the lock");
            Thread.sleep(1000);
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        } finally {
            System.out.println(Thread.currentThread().getName() + " Lock release");
            unFarenessLock.unlock();
        }
    }

    public static void main(String[] args) {
        UnFainessLock unFarenessLock = new UnFainessLock();
        Runnable task = new Runnable() {
            @Override
            public void run() {
                unFarenessLock.acessResource();
            }
        };

        Thread t1 = new Thread(task, "Thread 1");
        Thread t2 = new Thread(task, "Thread 2");
        Thread t3 = new Thread(task, "Thread 3");

        t1.start();
        t2.start();
        t3.start();

    }
}

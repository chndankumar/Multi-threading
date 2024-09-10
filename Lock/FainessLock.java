package Mutithreading.Lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FainessLock {
    private final Lock farenessLock = new ReentrantLock(true);

    public void acessResource() {
        farenessLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " acquired the lock");
            Thread.sleep(1000);
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        } finally {
            System.out.println(Thread.currentThread().getName() + " Lock release");
            farenessLock.unlock();
        }
    }

    public static void main(String[] args) {
        FainessLock farenessLock = new FainessLock();
        Runnable task = new Runnable() {
            @Override
            public void run() {
                farenessLock.acessResource();
            }
        };

        Thread t1 = new Thread(task, "Thread 1");
        Thread t2 = new Thread(task, "Thread 2");
        Thread t3 = new Thread(task, "Thread 3");
        try {
            t1.start();
            t1.sleep(50);
            t2.start();
            t2.sleep(50);
            t3.start();
        } catch (Exception e) {

        }

    }
}

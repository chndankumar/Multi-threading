package Mutithreading.Lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockExample {

    private int count = 0;
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final Lock readLock = lock.readLock();
    private final Lock writeLock = lock.writeLock();

    public void increment() {
        writeLock.lock();
        try {
            count++;
        } finally {
            writeLock.unlock();
        }
    }

    public int getCount() {
        readLock.lock();
        try {
            return count;
        } finally {
            readLock.unlock();
        }
    }

    public static void main(String[] args) {
        ReadWriteLockExample readWriteLockExample = new ReadWriteLockExample();

        Runnable readTask = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName() + " read " + readWriteLockExample.getCount());
                }
            }
        };

        Runnable writeTask = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    readWriteLockExample.increment();
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                    }
                    System.out.println(Thread.currentThread().getName() + " incremented  ");
                }
            }
        };

        Thread writerThread = new Thread(writeTask);
        Thread readThread1 = new Thread(readTask);
        Thread readThread2 = new Thread(readTask);

        writerThread.start();
        readThread1.start();
        readThread2.start();

        try {
            writerThread.join();
            readThread1.join();
            readThread2.join();
        } catch (Exception e) {

        }
    }
}

package Mutithreading.Lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {
    Lock lock = new ReentrantLock();

    public void outer() {
        lock.lock();
        try {
            System.out.println("Outer is Running");
            inner();
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }
    }

    private void inner() {
        lock.lock();
        try {
            System.out.println("Inter is also called");
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantLockExample reentrantLockExample = new ReentrantLockExample();
        reentrantLockExample.outer();
    }
}

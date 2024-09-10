package Mutithreading.Lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {

    int balance = 70;

    private final Lock lock = new ReentrantLock(); // Ensure ReentrantLock is imported

    public void withdraw(int amount) {
        System.out.println(Thread.currentThread().getName() + " attempting to withdraw  " + amount);

        try {
            // lock.lock(); this let wating the other thread to wait for their chance
            // at below line it will wait for the
            if (lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                if (amount < balance) {
                    try {
                        System.out.println(Thread.currentThread().getName() + " proceeding with withdraw " + amount);
                        Thread.sleep(5000);
                        balance -= amount;
                        System.out.println(
                                Thread.currentThread().getName() + " completed the withdraw, amount left: " + balance);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    } finally {
                        lock.unlock();
                    }
                } else {
                    System.out.println(Thread.currentThread().getName() + " insufficient balance " + balance);
                }
            } else {
                System.out.println(Thread.currentThread().getName() + " could not acquire the lock.. will try later");
            }
            lock.unlock();
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }
        if (Thread.currentThread().interrupted()) {
            System.out.println(Thread.currentThread().getState());
        }
    }
}

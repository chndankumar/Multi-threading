package Mutithreading.Synchronization;

public class Counter {
    int count = 0;

    // this resourece used by two thread to prevent the inaccuracy in data we have
    // Synchronise the method or put that tack in Synchronise block where at time
    // only one thread will use the resoucrs and other will wait
    public synchronized void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}

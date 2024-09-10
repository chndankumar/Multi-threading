package Mutithreading.Synchronization;

public class Mythread extends Thread {
    private Counter counter;

    public Mythread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            counter.increment();
        }
    }
}

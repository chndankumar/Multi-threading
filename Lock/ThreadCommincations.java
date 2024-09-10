package Mutithreading.Lock;

class SharedResource {
    private boolean flag;
    int data;

    public synchronized void produce(int value) throws InterruptedException {
        while (flag) {
            wait(); // Waits for the flag to be true
        }
        data = value;
        flag = true;
        System.out.println("Produced: " + data);
        notify();
    }

    public synchronized int consume() {
        while (!flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        flag = false;
        System.out.println("Consume: " + data);
        notify(); // Notifies waiting threads
        return data;
    }
}

class Producer implements Runnable {
    private SharedResource resource;

    public Producer(SharedResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                resource.produce(i);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

class Consumer implements Runnable {
    private SharedResource resource;

    public Consumer(SharedResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            int value = resource.consume();
        }
    }
}

public class ThreadCommincations {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();
        Thread t1 = new Thread(new Producer(resource));
        Thread t2 = new Thread(new Consumer(resource));
        t1.start();
        t2.start();
    }
}

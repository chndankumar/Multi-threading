package Mutithreading;

public class ThreadCycle extends Thread {
    @Override
    public void run() {
        // System.out.println(Thread.currentThread().getName());
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // different states of a thread

        ThreadCycle threadCycle = new ThreadCycle(); // new
        System.out.println(threadCycle.getState());

        threadCycle.start(); // RUNNABLE
        System.out.println(threadCycle.getState());

        Thread.sleep(100);

        System.out.println(threadCycle.getState());// TIMED_WAITING
        threadCycle.join();
        System.out.println(threadCycle.getState());// TERMINATED

        System.out.println(threadCycle.isAlive());

        System.out.println("threadCycle thread is running inside the " + Thread.currentThread().getName());
        System.out.println("state of main thread " + Thread.currentThread().getState());
    }
}

package Mutithreading;

// The yield() method causes the currently executing thread to temporarily pause
// and allows other threads of the same priority to execute. It doesn’t
// guarantee when the yielding thread will run again.

public class ThreadYield extends Thread {

    public ThreadYield(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + " is running");
            Thread.yield();
        }
    }

    public static void main(String[] args) {
        ThreadYield ty1 = new ThreadYield("Thread 1");
        ThreadYield ty2 = new ThreadYield("Thread 2");
        ty1.start();
        ty2.start();
    }
}
// Impact: When yield() is called, the current thread voluntarily gives up the
// CPU, allowing other threads of equal priority to execute. However, the
// operating system decides whether the yielding thread will actually pause or
// continue executing.
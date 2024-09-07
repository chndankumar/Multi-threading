package Mutithreading;

// The interrupt() method is used to signal to a thread that it should stop what
// it's doing and do something else. The thread itself has to handle this
// interruption; the method does not stop the thread on its own.

public class ThreadInterrupt extends Thread {

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            // this line will not print as we have use the intrupt method in main
            System.out.println("Thread is sleeping..................");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ThreadInterrupt threadInterrupt = new ThreadInterrupt();
        threadInterrupt.start();
        threadInterrupt.interrupt();
        System.out.println(threadInterrupt.getState());
    }
}
// Usage: Interrupts are useful when you want to gracefully stop or change the
// behavior of a thread. For example, if the thread is blocked (e.g., in sleep
// or wait), the interrupt will wake it up by throwing an InterruptedException.
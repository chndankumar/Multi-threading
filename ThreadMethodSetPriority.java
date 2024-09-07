package Mutithreading;

// In Java, each thread is assigned a priority, which helps the operating system
// determine the order in which threads should be scheduled for execution.
// Thread priority ranges from 1 (lowest) to 10 (highest), with 5 being the
// default priority. However, thread priorities are not guaranteed to be honored
// by all operating systems.

public class ThreadMethodSetPriority extends Thread {

    public ThreadMethodSetPriority(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            String a = "";
            for (int j = 0; j < 100000; j++) {
                a += "a";
            }
            System.out.println(Thread.currentThread().getName() + " - priority  " + Thread.currentThread().getPriority()
                    + " -count  " + i);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        // ThreadMethodSetPriority threadMethod = new
        // ThreadMethodSetPriority("Chandan");

        ThreadMethodSetPriority low = new ThreadMethodSetPriority("low");
        ThreadMethodSetPriority normal = new ThreadMethodSetPriority("normal");
        ThreadMethodSetPriority high = new ThreadMethodSetPriority("high");

        low.setPriority(Thread.MIN_PRIORITY);
        high.setPriority(Thread.MAX_PRIORITY);
        normal.setPriority(Thread.NORM_PRIORITY);
        low.start();
        high.start();
        normal.start();

    }
}
// Impact: Higher priority threads are more likely to be executed before lower
// priority threads. But note that this is dependent on the operating system’s
// thread scheduling mechanism.

package Mutithreading;

// A daemon thread is a background thread that runs for supporting tasks (like
// garbage collection in Java). The JVM will exit as soon as all user threads
// (non-daemon threads) finish, even if daemon threads are still running.
//  You can make a thread a daemon thread by calling setDaemon(true) before starting 
//  the thread. Once the thread has started, you cannot change its daemon status.

public class ThreadDemon extends Thread {

    @Override
    public void run() {
        while (true) {
            System.out.println(Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        ThreadDemon threadDemon = new ThreadDemon();
        threadDemon.setDaemon(true);
        threadDemon.start();
        System.out.println("Main thread task is done");
    }
}
// Key Point: Daemon threads are terminated automatically when all user threads
// are finished, even if they are still running. This makes them perfect for
// background tasks like monitoring or garbage collection.
// Daemon threads will be terminated when the JVM shuts down, meaning you don’t
// need to manually stop them. They are useful for background tasks that don’t
// need to outlive the main program.
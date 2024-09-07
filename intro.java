package Mutithreading;

public class intro {
    public static void main(String[] args) {
        Thread.currentThread().setName("my main");
        System.out.println(Thread.currentThread().getName());
        MyThread myThread = new MyThread();
        myThread.start();
        while (true) {
            System.out.println("world");
        }

    }
}

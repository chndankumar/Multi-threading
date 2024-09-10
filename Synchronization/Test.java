package Mutithreading.Synchronization;

public class Test {
    public static void main(String[] args) {
        Counter counter = new Counter();
        Mythread th1 = new Mythread(counter);
        Mythread th2 = new Mythread(counter);
        th1.start();
        th2.start();

        try {
            th1.join();
            th2.join();
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        System.out.println(counter.getCount());
    }
}

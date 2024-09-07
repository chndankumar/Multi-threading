package Mutithreading;

public class MyThread extends Thread {

    @Override
    public void run() {
        while (true) {
            System.out.println("hello");
        }
    }
}

package Mutithreading;

public class MyRunnable implements Runnable {

    @Override
    public void run() {
        while (true) {
            System.out.println("i am from runnable");
        }
    }

}

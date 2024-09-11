package Mutithreading.Executors;

import java.util.concurrent.*;;

class RunnableExample implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class CallableExample implements Callable {
    @Override
    public Object call() throws Exception {
        Thread.sleep(0);
        return null;
    }
}

public class RunandCall {
    public static void main(String[] args) {
    }
}
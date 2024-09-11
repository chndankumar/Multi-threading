package Mutithreading.Executors;

import java.util.concurrent.*;

public class introWithExcutors {
    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();
        ExecutorService executorServices = Executors.newFixedThreadPool(9);

        ExecutorService executorService = Executors.newCachedThreadPool();
        // this create the many thread depend on run time requirement of the situtions
        // where we do not know about the how many thread do we need to excute the task

        for (int i = 0; i < 11; i++) {
            int finali = i;
            executorServices.submit(() -> {
                int res = fibonacci(finali);
                System.out.println(res);
            });
        }
        // executorServices.shutdown();// after shutdown you can not assign any thread
        // or task to executorService
        executorServices.shutdownNow(); // it will shut down at same movement

        // try {
        // // executorServices.awaitTermination(11, TimeUnit.SECONDS);
        // while (!executorServices.awaitTermination(1000, TimeUnit.MILLISECONDS)) {
        // System.out.println("Wating.......");
        // }
        // } catch (InterruptedException e) {
        // Thread.currentThread().interrupt();
        // }
        System.out.println("Total Time taken " + (System.currentTimeMillis() - startTime));
    }

    private static int fibonacci(int i) {
        if (i == 0 || i == 1) {
            return i;
        }
        int res1 = fibonacci(i - 1);
        int res2 = fibonacci(i - 2);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return res1 + res2;
    }

}

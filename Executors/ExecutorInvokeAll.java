package Mutithreading.Executors;

import java.util.concurrent.*;
import java.util.*;

public class ExecutorInvokeAll {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Callable<Integer> callable1 = () -> {
            System.out.println("Task 1");
            Thread.sleep(1000);
            return 1;
        };

        Callable<Integer> callable2 = () -> {
            System.out.println("Task 2");
            Thread.sleep(1000);
            return 2;
        };

        Callable<Integer> callable3 = () -> {
            System.out.println("Task 3");
            Thread.sleep(1000);
            return 3;
        };

        List<Callable<Integer>> list = Arrays.asList(callable1, callable2, callable3);

        // List<Future<Integer>> futures = null;
        // try {
        // futures = executorService.invokeAll(list, 1, TimeUnit.SECONDS);
        // } catch (InterruptedException e) {

        // e.printStackTrace();
        // }

        try {
            int i = executorService.invokeAny(list);
            System.out.println(i);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        // for (Future<Integer> f : futures) {
        // try {
        // System.out.println(f.get());
        // } catch (CancellationException e) {
        // System.out.println(e);

        // } catch (InterruptedException | ExecutionException e) {
        // e.printStackTrace();
        // }
        // }

        executorService.shutdown();
        System.out.println("Task Done");
    }
}

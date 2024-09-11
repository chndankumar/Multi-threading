package Mutithreading.Executors;

import java.util.concurrent.*;

public class FutureExample {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Future<Integer> future1 = executorService.submit(() -> 42);
        System.out.println(future1.get());
        System.out.println(future1.isDone());

        Future<?> future2 = executorService.submit(() -> {
            System.out.println("things done");
        });
        System.out.println(future2.get());
        System.out.println(future2.isDone());

        // Runnable runnable = () -> "hello ji"; this will do not return any value
        // because is void run method
        Callable<String> callable = () -> "hello ji";// it has call method that have generic type return
        Future<String> future3 = executorService.submit(callable);
        System.out.println(future2.get());

        Future<String> future4 = executorService.submit(() -> {
            System.out.println("things done");
        }, "printed");
        System.out.println(future4.get());

        Future<Integer> future5 = executorService.submit(() -> {
            Thread.sleep(2000);
            return 1;
        });

        Integer i = null;
        try {
            i = future5.get(1, TimeUnit.SECONDS);
            System.out.println(future5.isDone());
            System.out.println(i);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {

        }

        future5.cancel(true);
        System.out.println(future5.isCancelled());
        executorService.shutdown();
        Thread.sleep(1);
        System.out.println(executorService.isTerminated());

    }
}

package Mutithreading.CountdownLatch;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.Callable;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CyclicBarrierExample {
    public static void main(String[] args) {
        int numberService = 3;
        ExecutorService executorService = Executors.newFixedThreadPool(numberService);
        CyclicBarrier barrier = new CyclicBarrier(numberService);

        Future<String> future1 = executorService.submit(new DependencyService(barrier));
        Future<String> future2 = executorService.submit(new DependencyService(barrier));
        Future<String> future3 = executorService.submit(new DependencyService(barrier));

        barrier.getParties();
        barrier.reset();
        System.out.println("All thread finished successfully.... Starting main......");
        executorService.shutdown();
    }
}

class DependencyService implements Callable<String> {
    private final CyclicBarrier barrier;

    public DependencyService(CyclicBarrier barrier) {
        this.barrier = barrier;
    }

    @Override
    public String call() throws Exception {
        System.out.println(Thread.currentThread().getName() + "Service Stared");
        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName() + "wating at barrier");
        barrier.await();
        return "ok";
    }
}
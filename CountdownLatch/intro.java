package Mutithreading.CountdownLatch;

import java.util.concurrent.*;

public class intro {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        int numberService = 3;
        ExecutorService executorService = Executors.newFixedThreadPool(numberService);
        CountDownLatch latch = new CountDownLatch(numberService);
        Future<String> future1 = executorService.submit(new DependencyService(latch));
        Future<String> future2 = executorService.submit(new DependencyService(latch));
        Future<String> future3 = executorService.submit(new DependencyService(latch));
        latch.await();
        // future1.get();
        // future2.get();
        // future3.get();
        // insted of doing this we can use CountDown latch to get finish the work

        System.out.println("All thread finished successfully.... Starting main......");
        executorService.shutdown();
    }
}

class DependencyService implements Callable<String> {
    private final CountDownLatch latch;

    public DependencyService(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public String call() throws Exception {
        try {
            System.out.println(Thread.currentThread().getName() + "Service Stared");
            Thread.sleep(1000);
        } finally {
            latch.countDown();
        }
        return "ok";
    }
}

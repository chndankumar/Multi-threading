package Mutithreading.Executors;

import java.util.concurrent.*;

public class ScheduleExecutor {
    public static void main(String[] args) {
        ScheduledExecutorService scheduleExecutor = Executors.newScheduledThreadPool(2);
        scheduleExecutor.schedule(() -> System.out.println("Hello ji"), 1, TimeUnit.SECONDS);

        scheduleExecutor.scheduleAtFixedRate(() -> System.out.println("Print After every 5 Second"), 5, 5,
                TimeUnit.SECONDS);

        scheduleExecutor.scheduleWithFixedDelay(() -> System.out.println("Print After every 5 Second"), 5, 5,
                TimeUnit.SECONDS);

        scheduleExecutor.schedule(() -> {
            System.out.println("Hello ji");
            scheduleExecutor.shutdown();
        }, 20, TimeUnit.SECONDS);
    }
}

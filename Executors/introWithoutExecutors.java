package Mutithreading.Executors;

public class introWithoutExecutors {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        Thread[] threads = new Thread[11];
        for (int i = 0; i < 11; i++) {
            int finali = i;
            threads[i] = new Thread(() -> {
                int res = fibonacci(finali);
                System.out.println(res);
            });
            threads[i].start();
        }
        for (Thread th : threads) {
            try {
                th.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
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

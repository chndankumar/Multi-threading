package Mutithreading.CountdownLatch;

import java.util.*;
import java.util.concurrent.CompletableFuture;

public class CompletableFutureExample {
    public static void main(String[] args) {
        CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
                System.out.println("worker");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "ok";
        });
        String s = null;
        s = cf.getNow("Noooo...");
        System.out.println(s);
        System.out.println("main");
    }
}

package uz.pdp;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class MainTimeOut {

    public static void main(String[] args) throws InterruptedException {
        CompletableFuture<Integer> first = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return 20;
        });

//        first
//                .orTimeout(2, TimeUnit.SECONDS)
//                .exceptionally(throwable -> {
//                    throwable.printStackTrace();
//                    return -1;
//                })
//                .thenAccept(System.out::println);

        first
                .completeOnTimeout(30, 2, TimeUnit.SECONDS)
                .thenAccept(System.out::println);

        System.out.println("MAin");
        Thread.sleep(6000);

    }
}

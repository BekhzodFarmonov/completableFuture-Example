package uz.pdp;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class MainAnyOf {

    public static void main(String[] args) throws InterruptedException {
        CompletableFuture<Integer> first = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return 20;
        });
        CompletableFuture<String> second = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "Ketmon";
        });
        CompletableFuture<Double> third = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return 36.6;
        });

        CompletableFuture.anyOf(first, second, third)
                .thenRun(() -> {
                    first.thenAccept(System.out::println);
                    second.thenAccept(System.out::println);
                    third.thenAccept(System.out::println);
                });

        System.out.println("MAin");
        Thread.sleep(6000);

    }
}

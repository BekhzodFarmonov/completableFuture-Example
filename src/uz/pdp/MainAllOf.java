package uz.pdp;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Function;

public class MainAllOf {

    public static void main(String[] args) throws InterruptedException {
        CompletableFuture<Integer> first = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return 20;
        });
        CompletableFuture<String> second = CompletableFuture.supplyAsync(() -> "Ketmon");
        CompletableFuture<Double> third = CompletableFuture.supplyAsync(() -> 36.6);

        CompletableFuture.allOf(first, second, third)
                .thenRun(() -> {
                    try {
                        System.out.println(first.get());
                    } catch (InterruptedException | ExecutionException e) {
                        throw new RuntimeException(e);
                    }
                });

        System.out.println("MAin");
        Thread.sleep(6000);

    }
}

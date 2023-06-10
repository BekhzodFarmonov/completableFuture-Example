package uz.pdp;

import java.util.concurrent.CompletableFuture;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        CompletableFuture<Integer> price = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return 20;
        });
        CompletableFuture<String> exchange = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "11480UZS";
        });


        Function<String,Integer> strToInt = str -> Integer.valueOf(str.replaceAll("\\D",""));
        exchange.thenApply(strToInt)
                .thenCombine(price,
                        (integer, integer2) -> (double) (integer * integer2))
                .thenAccept(aDouble -> {
                    System.out.println("Ketmon narxi: " + aDouble);
                });

        Thread.sleep(6000);

    }
}

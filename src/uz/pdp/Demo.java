package uz.pdp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;

public class Demo {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        getEmail(1)
                .thenCompose(email ->
                        getPlaylist(email)
                                .thenApply(playlist -> {
                                    List<String> res = new ArrayList<>();
                                    for (String music : playlist)
                                        res.add(music + " / change");

                                    return res;
                                })).thenAccept(System.out::println);


        System.out.println("Main finished");
        System.out.println(Thread.currentThread().getName());

        Thread.sleep(6000);

    }

    static CompletableFuture<String> getEmail(Integer id) {
        return CompletableFuture.supplyAsync(() -> users.get(id));
    }

    static CompletableFuture<List<String>> getPlaylist(String email) {
        return CompletableFuture.supplyAsync(() -> playlist.get(email));
    }

    static Map<Integer, String> users = new ConcurrentHashMap<>() {{
        put(1, "ketmon@gmail.com");
        put(2, "tesha@gmail.com");
    }};

    static Map<String, List<String>> playlist = new ConcurrentHashMap<>() {{
        put("ketmon@gmail.com", List.of("Kecha", "Bugun", "Endi"));
        put("tesha@gmail.com", List.of("Aldama", "Bla", "Battar"));
    }};
}

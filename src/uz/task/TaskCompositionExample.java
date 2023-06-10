package uz.task;

import java.util.concurrent.CompletableFuture;

public class TaskCompositionExample {
    public static void main(String[] args) {
        CompletableFuture<String> getEmailTask=CompletableFuture.supplyAsync(()->{
            String email=etrieveEmailById(123);
            return email;
        });
        CompletableFuture<String> getPlayListTask=getEmailTask.thenCompose(email->{
            CompletableFuture<String> processEmailTask = CompletableFuture.supplyAsync(() -> {
                // Simulating processing of email to get playlist
                String playlist = processEmail(email);
                return playlist;
            });
            return processEmailTask;
        });
        CompletableFuture<Void> performActionTask = getPlayListTask.thenAccept(playlist -> {
            // Simulating performing an action using the playlist
            performAction(playlist);
        });

        CompletableFuture.allOf(getEmailTask, getPlayListTask, performActionTask).join();
    }
    private static void performAction(Object playlist) {
        System.out.println("Performing action with playlist: " + playlist);
    }
    private static String processEmail(String email) {
        return "playlist123";
    }
    private static String etrieveEmailById(int id) {
        return "example@email.com";
    }
}

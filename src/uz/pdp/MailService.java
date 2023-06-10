package uz.pdp;

import java.util.concurrent.CompletableFuture;

public class MailService {

    public static void sendEmail() {
        LongTask.longTask();
        System.out.println(Thread.currentThread().getName()+" email");
        System.out.println("Email was sent");
    }

    public static CompletableFuture<Void> sendEmailAsync() {
        return CompletableFuture.runAsync(MailService::sendEmail);
    }
}

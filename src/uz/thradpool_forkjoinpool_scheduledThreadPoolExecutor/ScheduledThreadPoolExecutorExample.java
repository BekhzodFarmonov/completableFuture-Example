package uz.thradpool_forkjoinpool_scheduledThreadPoolExecutor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolExecutorExample {
    public static void main(String[] args) {
        ScheduledThreadPoolExecutor executor = (ScheduledThreadPoolExecutor) Executors.newScheduledThreadPool(8);

        // Schedule a task to run after a delay
        executor.schedule(new Task("Delayed Task"), 5, TimeUnit.SECONDS);

        // Schedule a task to run periodically
        executor.scheduleAtFixedRate(new Task("Periodic Task"), 1, 3, TimeUnit.SECONDS);

        // Shutdown the executor after some time
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executor.shutdown();
    }}
class Task implements Runnable {
    private String taskName;

    public Task(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run() {
        System.out.println("Executing: " + taskName + " at " + System.console());
    }
}

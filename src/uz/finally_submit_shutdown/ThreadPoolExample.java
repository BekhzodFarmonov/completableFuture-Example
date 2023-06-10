package uz.finally_submit_shutdown;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExample {
    public static void main(String[] args) {
        ExecutorService executor = null;
        try {
            // Create a fixed-size thread pool with 3 threads
            executor = Executors.newFixedThreadPool(8);

            // Submit tasks to the thread pool
            for (int i = 0; i < 5; i++) {
                executor.submit(new Task(i + 1));
            }
        } finally {
            // Shutdown the thread pool in the finally block to ensure it always gets called
            if (executor != null) {
                executor.shutdown();
            }
        }
    }
}
class Task implements Runnable {
    private int taskId;

    public Task(int taskId) {
        this.taskId = taskId;
    }
    @Override
    public void run() {
        System.out.println("Task " + taskId + " is running.");
    }
}

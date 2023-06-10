package uz;

import java.util.concurrent.*;

public class CallableExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(8);

        // Submit a callable task to the thread pool
        Future<String> future = executor.submit(new Task());

        // Perform other operations while the task is executing

        try {
            // Retrieve the result of the task (blocking call)
            String result = future.get();
            System.out.println("Task result: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Shutdown the thread pool
        executor.shutdown();
    }
}

class Task implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println("Task started.");
        TimeUnit.SECONDS.sleep(30); // Simulate some work for 3 seconds
        System.out.println("Task completed.");
        return "Task result";
    }
}

package uz.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(8);
        for (int i = 0; i < 10; i++) {
            Runnable worker = new WorkerThread("Task " + (i + 1));
            executor.execute(worker);
        }
        executor.shutdown();
    }
}
class WorkerThread implements Runnable {
    private String taskName;

    public WorkerThread(String taskName) {
        this.taskName = taskName;
    }
    @Override
    public void run() {
        System.out.println("Starting: " + taskName);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Completed: " + taskName);
    }
}

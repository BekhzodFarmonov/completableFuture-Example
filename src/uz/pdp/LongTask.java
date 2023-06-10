package uz.pdp;

public class LongTask {

    public static void longTask(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

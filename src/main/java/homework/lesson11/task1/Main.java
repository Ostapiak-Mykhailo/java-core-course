package homework.lesson11.task1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executor = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 10; i++) {
            executor.submit(new Counter());
        }
        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.SECONDS);

        System.out.println(Counter.COUNTER);
    }
}

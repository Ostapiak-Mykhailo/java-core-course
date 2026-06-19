package homework.lesson11.task1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 10; i++) {
            ExecutorService executor = Executors.newFixedThreadPool(10);
            executor.submit(new Counter());
            executor.close();
        }
        System.out.println(Counter.COUNTER);
    }
}

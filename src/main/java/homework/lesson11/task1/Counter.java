package homework.lesson11.task1;

import java.util.concurrent.atomic.AtomicInteger;

public class Counter implements Runnable {

    public static AtomicInteger COUNTER = new AtomicInteger(0);

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            nextCounter();
        }
    }

    public static void nextCounter() {
        COUNTER.incrementAndGet();
    }
}

package homework.lesson10;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static int COUNTER = 0;

    public static void main(String[] args) throws InterruptedException {

        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new Counter());
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println(COUNTER);
    }

    public static class Counter implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                nextCounter();
            }
        }

        public static void nextCounter() {
            COUNTER++;
        }
    }
}

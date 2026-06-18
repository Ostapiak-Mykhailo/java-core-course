package homework.lesson11.task1;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        List<Thread> threadList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new Counter());
            threadList.add(thread);
            thread.start();
        }
        for (Thread thread : threadList) {
            thread.join();
        }
        System.out.println(Counter.COUNTER);
    }
}

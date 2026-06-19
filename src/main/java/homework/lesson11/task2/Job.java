package homework.lesson11.task2;

import java.time.LocalDateTime;

public class Job implements Runnable {
    @Override
    public void run() {
        System.out.println(LocalDateTime.now());
    }
}

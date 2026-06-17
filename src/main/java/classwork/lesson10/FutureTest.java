package classwork.lesson10;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        List<FutureTask<LocalDateTime>> futureTasks = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Callable<LocalDateTime> collable = new CurrentDateTime();

            FutureTask<LocalDateTime> futureTask = new FutureTask<>(collable);
            futureTasks.add(futureTask);
            new Thread(futureTask).start();
        }

        for (FutureTask<LocalDateTime> futureTask: futureTasks){
            System.out.println(futureTask.get());
        }
        
    }

    public static class CurrentDateTime implements Callable<LocalDateTime> {
        @Override
        public LocalDateTime call() {
            LocalDateTime now = LocalDateTime.now();
            System.out.println("Date for " + Thread.currentThread().getName() + ": " + now);
            return now;
        }
    }
}

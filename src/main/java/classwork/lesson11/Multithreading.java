package classwork.lesson11;

import classwork.lesson10.FutureTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Multithreading {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        List<Future<LocalDateTime>> futures = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            futures.add(executorService.submit(new FutureTest.CurrentDateTime()));
        }

        futures.get(3).cancel(false); // відміна 3 задачі

        executorService.shutdown(); // екзекутор треба закривати

//        for (Future<LocalDateTime> future: futures){
//            System.out.println(future.get());
//        }
    }
}

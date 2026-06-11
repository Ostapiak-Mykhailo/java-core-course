package classwork.lesson10;

import java.util.ArrayList;
import java.util.List;

public class MultiThreading {

    public static void main(String[] args) throws InterruptedException {


        System.out.println("Thread:" + Thread.currentThread().getName());

        List<Thread> threads = new ArrayList<>();

        System.out.println("before sleep main");
        Thread.sleep(2000);
        System.out.println("after sleep main");

        for (int i = 0; i < 10; i++) {
//            Printer printer = new Printer("Gabella" + i);
//            Thread thread = new Thread(printer);
//            thread.start();

            PrinterThread thread = new PrinterThread();
            threads.add(thread);
            thread.start();
        }

        System.out.println("1.Thread:" + Thread.currentThread().getName());

        // чекаємо завершення всіх потоків
        for (Thread thread: threads) {
            thread.join();
        }

        System.out.println("2.Thread:" + Thread.currentThread().getName());

    }

    public static class Printer implements Runnable {

        private String name;

        public Printer(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println("Thread: " + Thread.currentThread().getName());
            System.out.println("I`m " + this.name);
        }
    }

    public static class PrinterThread extends Thread{

        @Override
        public void run() {
            System.out.println("before sleep " + Thread.currentThread().getName());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.getStackTrace();
            }
            System.out.println("after sleep");
            System.out.println("PrinterThread prints message " + Thread.currentThread().getName());
        }
    }
}

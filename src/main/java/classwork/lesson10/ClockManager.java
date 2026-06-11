package classwork.lesson10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ClockManager {

    public static boolean IS_CLOCK_RUN = true;


    public static void main(String[] args) throws InterruptedException, IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Thread thread = new Thread(new Clock());
        thread.start();

        System.out.println("after starting clock");

        Thread.sleep(5500);

        System.out.println("We`ve wake up");
        System.out.println("wanna leave the alarm clock blaring?");

        IS_CLOCK_RUN = Boolean.parseBoolean(reader.readLine());

        if (!IS_CLOCK_RUN){
            thread.interrupt();
        }
    }

    public static class Clock implements Runnable {
        @Override
        public void run() {
            Thread current = new Thread();
            while (!current.isInterrupted()) {
                try {
                    Thread.sleep(3500);
                } catch (InterruptedException e) {
                    System.out.println("clock was switched off while sleeping");
                    return;
                }
                System.out.println("tick");
            }
        }
    }
}

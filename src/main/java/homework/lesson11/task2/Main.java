package homework.lesson11.task2;

public class Main {

    public static void main(String[] args) {

        JobQueue jobQueue = new JobQueue();

        Thread thread1 = new Thread(new JobGetter(jobQueue));
        Thread thread2 = new Thread(new JobAdder(jobQueue));

        thread2.start();
        thread1.start();

    }
}

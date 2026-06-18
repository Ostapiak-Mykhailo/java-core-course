package homework.lesson11.task2;

import java.util.ArrayList;

public class JobQueue {

    ArrayList<Runnable> jobs = new ArrayList<>();

    public synchronized void put(Runnable job) {
        jobs.add(job);
        this.notifyAll();
    }

    public synchronized Runnable getJob() throws InterruptedException {
        while (jobs.isEmpty()) {
            this.wait();
        }
        return jobs.removeFirst();
    }
}

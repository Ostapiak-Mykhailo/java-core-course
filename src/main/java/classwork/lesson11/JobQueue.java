package classwork.lesson11;

import java.util.ArrayList;

public class JobQueue {

    ArrayList<Runnable> jobs = new ArrayList<>();

    public synchronized void put(Runnable job) {
        jobs.add(job);
        this.notifyAll();
    }

    public synchronized Runnable get() throws InterruptedException {
        while (jobs.isEmpty()) {
            this.wait();
        }
        return jobs.getFirst();
    }
}

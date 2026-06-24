package homework.lesson11.task2;

import java.util.LinkedList;

public class JobQueue {

    private final LinkedList<Runnable> jobs = new LinkedList<>();

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

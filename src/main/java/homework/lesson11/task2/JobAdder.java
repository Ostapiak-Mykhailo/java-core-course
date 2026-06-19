package homework.lesson11.task2;

public class JobAdder implements Runnable {

    private final JobQueue jobQueue;

    public JobAdder(JobQueue jobQueue) {
        this.jobQueue = jobQueue;
    }

    @Override
    public void run() {
        while (true) {
            jobQueue.put(new Job());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

package homework.lesson11.task2;

public class JobGetter implements Runnable {

    private JobQueue jobQueue;

    public JobGetter(JobQueue jobQueue) {
        this.jobQueue = jobQueue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Runnable job = jobQueue.getJob();
                job.run();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

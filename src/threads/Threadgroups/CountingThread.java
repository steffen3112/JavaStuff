package threads.Threadgroups;

public class CountingThread extends Thread {

    private Counter counter;

    public CountingThread(Counter counter) {
        this.counter = counter;
    }

    public void run() {

        while(counter.currentValue() <= counter.getLimit() && !Thread.currentThread().isInterrupted()) {
            System.out.println(counter.currentValue());
            counter.increment();
            ThreadUtils.safeSleep(1000);
        }
    }

}
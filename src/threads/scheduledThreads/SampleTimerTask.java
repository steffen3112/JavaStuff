package threads.scheduledThreads;

import java.util.TimerTask;

public class SampleTimerTask extends TimerTask {

    private final String message;
    private int count;

    public SampleTimerTask(String message) {
        this.message = message;
        count = 0;
    }


    @Override
    public void run() {
        count++;
        System.out.println(count + ": " +message);
    }
}

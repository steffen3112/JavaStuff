package threads.scheduledThreads;

import threads.Threadgroups.ThreadUtils;

import java.util.Timer;

public class Client {

    public static void main(String[] args) {

        // Start Timer as Daemon Thread, no need to cancel
        // since it no User Thread is running
        final Timer daemonTimer = new Timer("DaemonTimer", true);

        final long NO_DELAY = 0;
        daemonTimer.schedule(new SampleTimerTask("OnceImmediatly"), NO_DELAY, 1000);

        final long INITIAL_DELAY_FIVE_SEC = 5000;
        daemonTimer.schedule(new SampleTimerTask("AfterFiveSeconds"), INITIAL_DELAY_FIVE_SEC);

        final long FIXED_RATE_DELAY_THREE_SECONDS = 3000;
        daemonTimer.scheduleAtFixedRate(new SampleTimerTask("FIXED_RATE"), FIXED_RATE_DELAY_THREE_SECONDS, 3000);

        // stopTimerAfterDelay(daemonTimer);

    }

    private static void stopTimerAfterDelay(final Timer timer) {
        ThreadUtils.safeSleep(10 * 1000);
        timer.cancel();
    }

}

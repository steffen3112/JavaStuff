package threads.Threadgroups;

import java.util.concurrent.TimeUnit;

public final class ThreadUtils {


    /**
     * logs some status Information about the current Thread:
     * -Threadgroup, # of Thread
     * -logs each thread
     */
    public static void dumpThreads() {
        final ThreadGroup group =  Thread.currentThread().getThreadGroup();
        final int activeCount = group.activeCount();
        final Thread[] threads = new Thread[activeCount];
        group.enumerate(threads);

        System.out.println("Thread-Group " + group + " contains " + activeCount + " threads");

        for (final Thread thread : threads) {
            System.out.println("Thread: " + thread);
        }

    }

    /**
     * Stops the current Thread for the given Timeunit and duration
     * Catches the interrupted exception and sets the interrupted flag
     * @param timeUnit time metric
     * @param duration duration for given time metric
     * e.g.: {@code safeSleep(TimeUnit.Days, 2} --> Thread sleeps two days
     */
    public static void safeSleep(final TimeUnit timeUnit, final long duration) {
        safeSleep(timeUnit.toMillis(duration));
    }

    /**
     * Stops the current thread for {@code durationInMilliSecs}
     * @param durationInMilliSecs Duration to stop the current thread in milli-sec.
     */
    public static void safeSleep(final long durationInMilliSecs) {
        try {
            Thread.sleep(durationInMilliSecs);
        } catch (InterruptedException e) {

            //set the flag and terminate interrupted thread
            Thread.currentThread().interrupt();
        }
    }
    
}
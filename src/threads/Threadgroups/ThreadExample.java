package threads.Threadgroups;

public class ThreadExample {

    public static void main(final String[] args) throws InterruptedException {

        final Thread derivedThread = new CountingThread(new Counter(1, 10));

        derivedThread.start();

    }

}
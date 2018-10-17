package threads.Threadgroups;

public class ThreadExample {

    public static void main(final String[] args) throws InterruptedException {

        final Thread derivedThread = new CountingThread(new Counter(1, 10));
        final Thread datePrinter = new Thread(new DatePrinter());

        derivedThread.setName("Counting Thread");
        datePrinter.setName("Date Printer Runnable");

        derivedThread.start();
        datePrinter.start();

        ThreadUtils.dumpThreads();

    }

}
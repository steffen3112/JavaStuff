package threads.consumerProducer;

import threads.Threadgroups.ThreadUtils;

import java.util.List;

public class Producer implements Runnable {

    private final List<Item> sharedItems;
    private final long sleepTime;

    public Producer(final List<Item> items, final long sleepTime) {
        this.sharedItems = items;
        this.sleepTime = sleepTime;
    }

    @Override
    public void run() {
        int counter = 0;
        while(!Thread.currentThread().isInterrupted()) {

            final Item newItem = new Item("Item " + counter);
            System.out.println("Producing Item" + newItem);

            // acquire Lock, access shared data and add Item
            synchronized (sharedItems) {
                sharedItems.add(newItem);
                System.out.println("Added" + newItem);

                // Inform all waiting threads
                sharedItems.notifyAll();
            }

            counter++;
            ThreadUtils.safeSleep(sleepTime);
        }
    }
}

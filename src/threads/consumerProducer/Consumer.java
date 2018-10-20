package threads.consumerProducer;

import threads.Threadgroups.ThreadUtils;

import java.util.List;

public class Consumer implements Runnable {

    private final List<Item> sharedItems;
    private final long sleepTime;

    public Consumer(List<Item> sharedItems, long sleepTime) {
        this.sharedItems = sharedItems;
        this.sleepTime = sleepTime;
    }

    @Override
    public void run() {

        while (!Thread.currentThread().isInterrupted()) {
            boolean noItems = true;
            while(noItems) {

                synchronized (sharedItems) {
                    noItems = (sharedItems.size() == 0);
                    if(noItems) {
                        System.out.println("Waiting for Items");
                    }
                    else {
                        System.out.println("Consuming Item " + sharedItems.remove(0));
                    }

                    ThreadUtils.safeSleep(sleepTime);
                }

            }
        }

    }
}

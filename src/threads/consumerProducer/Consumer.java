package threads.consumerProducer;

import threads.Threadgroups.ThreadUtils;

import java.util.concurrent.BlockingDeque;

public class Consumer implements Runnable {

    private final BlockingDeque<Item> sharedItems;
    private final long sleepTime;
    private String consumerName;

    public Consumer(BlockingDeque<Item> sharedItems, long sleepTime, String consumerName) {
        this.sharedItems = sharedItems;
        this.sleepTime = sleepTime;
        this.consumerName = consumerName;
    }

    @Override
    public void run() {

        while (!Thread.currentThread().isInterrupted()) {

                synchronized (sharedItems) {

                    try {
                        System.out.println(consumerName +" waiting...");

                        waitForItemsAvailable();

                        final Item item = sharedItems.takeFirst();
                        System.out.println(consumerName + "Removing Item " + item);

                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }

                    ThreadUtils.safeSleep(sleepTime);

            }
        }

    }

    /*
        Its better to refactor the "condition" into a private method
        which ensures, that for multiple Threads none of them is getting
        a invalid state or is doing an invalid action
     */
    private void waitForItemsAvailable() throws InterruptedException {
        while(this.sharedItems.size() == 0) {
            sharedItems.wait();
        }
    }
}

package threads.consumerProducer;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Client {

    public static void main(String[] args) throws InterruptedException {

        final List<Item> sharedItems = new LinkedList<>();

        final Thread producer = new Thread(new Producer(sharedItems, 1000));
        final Thread consumer1 = new Thread(new Consumer(sharedItems, 1000, "Consumer #1"));
        final Thread consumer2 = new Thread(new Consumer(sharedItems, 500, "Consumer #2"));
        final Thread consumer3 = new Thread(new Consumer(sharedItems, 2000, "Consumer #3"));

        producer.start();
        consumer1.start();
        consumer2.start();
        consumer3.start();

        TimeUnit.SECONDS.sleep(20);

        producer.interrupt();
        consumer1.interrupt();
        consumer2.interrupt();
        consumer3.interrupt();

    }

}

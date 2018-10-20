package threads.consumerProducer;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Client {

    public static void main(String[] args) throws InterruptedException {

        final List<Item> sharedItems = new LinkedList<>();

        final Thread producer = new Thread(new Producer(sharedItems, 500));
        final Thread consumer= new Thread(new Consumer(sharedItems, 1000));

        producer.start();
        consumer.start();

        TimeUnit.SECONDS.sleep(20);

        producer.interrupt();
        consumer.interrupt();

    }

}

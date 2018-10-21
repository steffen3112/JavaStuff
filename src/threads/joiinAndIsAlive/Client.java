package threads.joiinAndIsAlive;

import threads.Threadgroups.ThreadUtils;
import threads.consumerProducer.Item;
import threads.consumerProducer.Producer;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

public class Client {

    public static void main(String[] args) throws InterruptedException {

        final int MAX_SIZE = 10;
        final BlockingDeque<Item> itemQueue = new LinkedBlockingDeque(MAX_SIZE);
        final Thread producerThread = new Thread(new Producer(itemQueue, 1000));
        producerThread.start();

        // Stop current Thread (main Thread) for 5 seconds
        producerThread.join(TimeUnit.SECONDS.toMillis(5));
        System.out.println("after join(): producer is Alive? " + producerThread.isAlive());

        // 1000ms production time
        System.out.println("Item Count after join: " + itemQueue.size());

        // => Main Thread
        System.out.println("Current Thread" + Thread.currentThread());
        // sleep main thread and let producer work two more seconds
        ThreadUtils.safeSleep(TimeUnit.SECONDS.toMillis(2));

        // interrupt producer
        producerThread.interrupt();

        // 1000ms production time + 7s wait time => ~7 Items in Queue
        System.out.println("Item-Count after interrupt(): " + itemQueue.size());
        System.out.println("after interrupt(): producer isAlive? " + producerThread.isAlive());

    }



}

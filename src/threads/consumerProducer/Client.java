package threads.consumerProducer;

import threads.LoggingUncaughtExceptionHandler;
import threads.Threadgroups.ThreadUtils;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

public class Client {

    public static void main(String[] args) throws InterruptedException {

        final int MAX_QUEUE_SIZE = 8;
        final BlockingDeque<Item> sharedItems = new LinkedBlockingDeque<>(MAX_QUEUE_SIZE);
        LoggingUncaughtExceptionHandler loggingUncaughtExceptionHandler = new LoggingUncaughtExceptionHandler();
        StoppableConsumer stoppableConsumer = new StoppableConsumer(sharedItems, 500, "StoppableConsumer #1");

        final Thread producer = new Thread(new Producer(sharedItems, 1000));
        final Thread consumer1 = new Thread(new Consumer(sharedItems, 1000, "Consumer #1"));
        final Thread consumer2 = new Thread(new Consumer(sharedItems, 500, "Consumer #2"));
        final Thread consumer3 = new Thread(new Consumer(sharedItems, 2000, "Consumer #3"));
        final Thread stoppableConsumerThread = new Thread(stoppableConsumer);
        stoppableConsumerThread.setDaemon(true);

        producer.start();

        ThreadUtils.safeSleep(TimeUnit.SECONDS, 5);


        producer.setName("Producer");
        consumer1.setName("Consumer #1");
        consumer2.setName("Consumer #2");
        consumer3.setName("Consumer #3");
        stoppableConsumerThread.setName("Stoppable Consumer #1");

        producer.setUncaughtExceptionHandler(loggingUncaughtExceptionHandler);
        consumer1.setUncaughtExceptionHandler(loggingUncaughtExceptionHandler);
        consumer2.setUncaughtExceptionHandler(loggingUncaughtExceptionHandler);
        consumer3.setUncaughtExceptionHandler(loggingUncaughtExceptionHandler);


        consumer1.start();
        consumer2.start();
        consumer3.start();
        stoppableConsumerThread.start();

        System.out.println("Stoppable Consumer Thread, before stopping: " + stoppableConsumerThread.isAlive());

        TimeUnit.SECONDS.sleep(20);

        producer.interrupt();
        consumer1.interrupt();
        consumer2.interrupt();
        consumer3.interrupt();
        stoppableConsumer.requestStop();

        System.out.println("Stoppable Consumer  " + stoppableConsumer.shouldStop() + " Thread " + stoppableConsumerThread.isAlive());

        ThreadUtils.safeSleep(TimeUnit.SECONDS, 5);

    }

}

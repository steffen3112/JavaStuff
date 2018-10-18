package threads.proxy;

import threads.Threadgroups.ThreadUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * Just a litte "experimentation" class with 2 Methods and a main method
 */
public class Client {

    /**
     * Checks if in the both ArrayLists ({@code unsafeIntegers} and {@code syncIntegers}) duplicates
     * appear. Since {@code runUnsafeMode()} creates two threads and is not synchronized, it might happen that at
     * one time both thread hold the same instance variable´s value.
     * Will not happen for the {@code runSynchronizedMode()} since it wraps the method call in a synchronized Object
     * @param args command Line arguments
     */
    public static void main(String[] args) {

        ArrayList<Integer> unsafeIntegers = runUnsafeMode();
        ArrayList<Integer> syncIntegers = runSynchronizedMode();

        // Not really the best solution, will work for first
        ThreadUtils.safeSleep(TimeUnit.SECONDS, 5);

        List<Integer> duplicatesUnsafe = unsafeIntegers.stream().filter(i -> Collections.frequency(unsafeIntegers, i) >1)
                .collect(Collectors.toList());

        List<Integer> duplicatesSync = syncIntegers.stream().filter(i -> Collections.frequency(syncIntegers, i) >1)
                .collect(Collectors.toList());

        System.out.println("#unsafeIntegers: " + duplicatesUnsafe.size());
        System.out.println("#duplicatesSync: " + duplicatesSync.size());
    }

    private static ArrayList<Integer> runSynchronizedMode() {

        UnsafeThreadClass unsafeThreadClass = new UnsafeThreadClass();

        Thread thread = new Thread(new SynchronizationProxy(unsafeThreadClass));
        Thread thread2 = new Thread(new SynchronizationProxy(unsafeThreadClass));

        thread.setName("Sync____#1");
        thread2.setName("Snyc____#2");

        thread.start();
        thread2.start();

        return unsafeThreadClass.getIntegerArrayList();

    }

    private static ArrayList<Integer> runUnsafeMode() {

        UnsafeThreadClass unsafeThreadClass = new UnsafeThreadClass();

        Thread thread = new Thread(unsafeThreadClass);
        Thread thread2 = new Thread(unsafeThreadClass);

        thread.setName("Unsafe____#1");
        thread2.setName("Unsafe____#2");

        thread.start();
        thread2.start();

        return unsafeThreadClass.getIntegerArrayList();
    }

}

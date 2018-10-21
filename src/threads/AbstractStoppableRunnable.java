package threads;

/**
 * This abstract class provides base functionality to stop a running thread,
 * all inheriting classes can request a stop by calling the super class.
 */
public abstract class AbstractStoppableRunnable implements Runnable {

    private volatile boolean shouldStop = false;

    public void requestStop() {
        shouldStop = true;
    }

    // TODO: handle restart in subclass
    public void requestRestart() {
        shouldStop = false;
    }

    public boolean shouldStop() {
        return shouldStop;
    }

    public void run() {

        while(!shouldStop) {
            // ...
        }

    }

}

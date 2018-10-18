package threads.proxy;

/**
 * Implements the Unsafe´s ThreadClass Interface and
 * wraps it methods in an synchronized Block
 */
public class SynchronizationProxy implements UnsafeThreadClassIF {

    private final UnsafeThreadClassIF original;

    public SynchronizationProxy(UnsafeThreadClassIF original) {
        this.original = original;
    }

    @Override
    public void run() {
        doSomething();
    }

    @Override
    public void doSomething() {
        synchronized (this) {
            original.doSomething();
        }
    }
}

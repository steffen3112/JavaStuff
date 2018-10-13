package threads.Threadgroups;

public class Counter {

    private int start;
    private int limit;

    public Counter(int start, int limit) {
        if(limit <= start) 
            throw new IllegalArgumentException();
        this.start = start;
        this.limit = limit;
    }

    public void increment() {
            start++;
    }

    public int currentValue() {
        return this.start;
    }

    public int getLimit() {
        return limit;
    }
}
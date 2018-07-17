package dataStructures.stack;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Spliterator;
import java.util.Stack;
import java.util.function.Consumer;

public class EnumerableStack<T> implements Iterable<T> {


    // ~Instance fields
    //--------------------------------------------------------------------------------------------------------------
    private LinkedList<T> linkedList;


    // ~Construct
    //--------------------------------------------------------------------------------------------------------------
    public EnumerableStack() {
        linkedList = new LinkedList<>();
    }

    // ~Overrides
    //--------------------------------------------------------------------------------------------------------------
    @Override
    public void forEach(Consumer<? super T> action) {
        int lastElement = linkedList.indexOf(linkedList.getLast());
        int size = linkedList.size();
        while(size > 0) {
            action.accept(linkedList.get(size-1));
            size--;
        }
    }

    @Override
    public Spliterator<T> spliterator() {
        return null;
    }

    @Override
    public Iterator<T> iterator() {
        return linkedList.iterator();
    }

    // ~Methods
    //--------------------------------------------------------------------------------------------------------------
    public void push(T type){
        linkedList.addLast(type);
    }

    public T pop() {
        T type = linkedList.getLast();
        linkedList.removeLast();
        return type;
    }

    public T peek() {
        return linkedList.getLast();
    }

    public long capacity() {
        return (long) linkedList.size();
    }

    public boolean isEmpty() {
        return linkedList.isEmpty();
    }





}

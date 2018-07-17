package dataStructures;

import dataStructures.lruCache.LruLinkedHashMap;
import dataStructures.stack.EnumerableStack;

import java.util.Iterator;
import java.util.Map;
import java.util.function.Consumer;

public class Client {

    public static void main(String[] args) {

        // ~Stack
        //--------------------------------------------------------------------------------------------------------------
/*        EnumerableStack<String> stringStack = new EnumerableStack<>();
        stringStack.push("Mein");
        stringStack.push("Name");
        stringStack.push("ist");
        stringStack.push("Steffen");

        Consumer<String> stringConsumer = input -> System.out.println("--------------------------\n" + input);
        stringStack.forEach(stringConsumer);

        stringStack.pop();
        stringStack.pop();
        stringStack.forEach(stringConsumer);

        Iterator<String> stringIterator = stringStack.iterator();
        while(stringIterator.hasNext()) {
            System.out.println(stringIterator.next());
        }*/


        // ~LRU Cache
        //--------------------------------------------------------------------------------------------------------------

        LruLinkedHashMap<String, String> lruLinkedHashMap = new LruLinkedHashMap<>(4);
        lruLinkedHashMap.put("1", "Oracle");
        lruLinkedHashMap.put("2", "MySQL");
        lruLinkedHashMap.put("3", "SQLServer");
        lruLinkedHashMap.put("4", "MariaDB");

        lruLinkedHashMap.entrySet().forEach(System.out::println);
        System.out.println("***************************************************");

        lruLinkedHashMap.get("1");
        lruLinkedHashMap.get("3");
        lruLinkedHashMap.get("2");

        lruLinkedHashMap.put("4", "PostgreSQL");

        lruLinkedHashMap.entrySet().forEach(System.out::println);


    }
}

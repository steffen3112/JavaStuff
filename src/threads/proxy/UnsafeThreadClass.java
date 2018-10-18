package threads.proxy;

import threads.Threadgroups.ThreadUtils;

import java.util.ArrayList;

public class UnsafeThreadClass implements UnsafeThreadClassIF {

    int number = 0;
    ArrayList<Integer> integerArrayList = new ArrayList<>();

    @Override
    public void run() {
        doSomething();
    }

    @Override
    public void doSomething() {
        while(number < 100000) {
            System.out.println(Thread.currentThread().getName() + " " + number);
            number++;
            integerArrayList.add(Integer.parseInt(String.valueOf(number)));
        }
    }

    public ArrayList<Integer> getIntegerArrayList() {
        return integerArrayList;
    }
}

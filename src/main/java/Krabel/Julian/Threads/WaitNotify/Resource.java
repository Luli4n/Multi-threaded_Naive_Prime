package Krabel.Julian.Threads.WaitNotify;

import java.util.ArrayList;
import java.util.List;

public class Resource {

    private List<Long> numbers;

    public Resource(){
        this.numbers=new ArrayList<>();
    }

    public synchronized long take() throws InterruptedException {
        while (numbers.size() == 0) {
            wait();
        }
        long ret = numbers.get(0);
        numbers.remove(0);
        return ret;
    }
    public synchronized void put(Long value) {
        this.numbers.add(value);
        notifyAll();
    }
}
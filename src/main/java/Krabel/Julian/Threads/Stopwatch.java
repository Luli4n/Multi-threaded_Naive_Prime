package Krabel.Julian.Threads;

import java.util.List;

public class Stopwatch implements Runnable{

    private final List<Thread> threadList;

    public Stopwatch(List<Thread> threadList) {
        this.threadList=threadList;
    }
    @Override
    public void run() {
        while(!Thread.currentThread().isInterrupted())
        {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                for(Thread th:threadList)
                {
                    th.interrupt();
                }
                break;
            }
        }

    }


}

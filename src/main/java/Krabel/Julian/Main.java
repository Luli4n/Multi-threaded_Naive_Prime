package Krabel.Julian;

import Krabel.Julian.Threads.*;
import Krabel.Julian.Threads.WaitNotify.Consumer;
import Krabel.Julian.Threads.WaitNotify.Producer;
import Krabel.Julian.Threads.WaitNotify.Resource;

import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main(String[] args) throws InterruptedException {

        int threadsNumber=1;

        if(args.length>0)
        {
            try {
                threadsNumber = Integer.parseInt(args[0]);
            } catch (NumberFormatException ex)
            {
              return;
            }
        }

        Resource primary_numbers=new Resource();
        Scores scores=new Scores();

        List<Thread> threads = new ArrayList<>();

        Consumer worker = new Consumer(primary_numbers,scores);
        Stopwatch stp=new Stopwatch(threads);

        Thread timer=new Thread(stp);
        Producer prd = new Producer(primary_numbers,timer);
        Thread producer=new Thread(prd);

        threads.add(producer);

        for(int i=0;i<threadsNumber;i++) {
            threads.add(new Thread(worker));
        }

        timer.start();

        for(Thread t:threads)
        {
            t.start();
        }

        for(Thread t:threads)
        {
            t.join();
        }

        System.out.print(scores.stringifyScores());
    }
}

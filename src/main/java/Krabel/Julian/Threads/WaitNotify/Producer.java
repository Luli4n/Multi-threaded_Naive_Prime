package Krabel.Julian.Threads.WaitNotify;

import java.util.Scanner;

import static java.lang.Math.abs;

public class Producer implements Runnable {
    private final Resource numbers;
    private Thread stoper;

    public Producer(Resource numbers,Thread stoper) {
        this.numbers = numbers;
        this.stoper=stoper;
    }
    @Override
    public void run() {
        Scanner scan=new Scanner(System.in);
        long number;
        while(!Thread.currentThread().isInterrupted()) {
            number=scan.nextLong();
            if(number>0)
                numbers.put(number);
            else {
                stoper.interrupt();
                break;
            }
        }
        }


}

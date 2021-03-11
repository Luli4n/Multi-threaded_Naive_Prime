package Krabel.Julian.Threads.WaitNotify;

import Krabel.Julian.Threads.Scores;

public class Consumer implements Runnable {

    private Resource numbers;
    private Scores scoreMap;

    public Consumer(Resource numbers,Scores scoreMap) {
        this.numbers = numbers;
        this.scoreMap=scoreMap;
    }

    @Override
    public void run() {
        boolean temp_primacy;
        long _number;

        while(!Thread.currentThread().isInterrupted()) {
            try {
                _number = numbers.take();
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
                break;
            }

            temp_primacy=is_primary(_number);
            scoreMap.put(_number,temp_primacy);
            System.out.print("number "+_number + "\tprime ?\t" + temp_primacy+"\n");
        }
    }


    public boolean is_primary(Long number)
    {
        for(int i=2;i<number;i++)
        {
            if(number%i==0)
            {
                return false;
            }
        }
        return true;
    }
}

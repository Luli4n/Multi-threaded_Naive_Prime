package Krabel.Julian.Threads;

import java.util.HashMap;
import java.util.Map;

public class Scores {
    private HashMap<Long,Boolean> numbers;
    public Scores(){
        this.numbers=new HashMap<>();
    }


    public synchronized void put(Long value,Boolean primacy) {
        this.numbers.put(value,primacy);
    }

    public String stringifyScores() {
        String str= "";

        for (Map.Entry<Long, Boolean> entry : numbers.entrySet()) {
            str+="number "+entry.getKey() + "\tprime ?\t" + entry.getValue()+"\n";
        }
        return str;
    }

}

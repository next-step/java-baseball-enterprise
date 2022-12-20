package domain;

import java.util.*;

public class Computer {
    private final ArrayList<Integer> numbers;

    public Computer(ArrayList<Integer> numbers) {
        this.numbers = numbers;
    }

    public Computer() {
        this.numbers =  new ArrayList<>();
    }

    public void reset(){
        this.numbers.clear();
        Random random = new Random();
        random.setSeed(System.currentTimeMillis());

        while(this.numbers.size() < 3){
            this.computerNumAdd(random.nextInt(9) + 1);
        }

    }
    public ArrayList<Integer> getNumbers() {
        return numbers;
    }

    public void computerNumAdd(int num){
        if (!this.numbers.contains(num)){
            this.numbers.add(num);
        }
    }
}

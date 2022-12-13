package domain;

import java.util.*;

public class Computer {
    private List<Integer> numbers;

    public Computer(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public Computer() {
        Set<Integer> numberSet = new HashSet<>();
        Random random = new Random();
        random.setSeed(System.currentTimeMillis());

        while(numberSet.size() < 3){
            numbers.add(random.nextInt(9) + 1);
        }
        this.numbers =  new ArrayList<Integer>(numberSet);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}

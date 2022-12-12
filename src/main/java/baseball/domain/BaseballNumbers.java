package baseball.domain;

import baseball.constant.Constant;

import java.util.ArrayList;
import java.util.List;

public class BaseballNumbers {
    private List<Integer> numbers;
    private final int length = Constant.LENGTH.getValue();

    public BaseballNumbers(){
        List<Integer> numbers = new ArrayList<>();
    }

    public boolean contains(int number){
        return numbers.contains(number);
    }

    public boolean add(int number){
        if (!contains(number)){
            numbers.add(number);
        }
        return isFull();
    }

    public boolean isFull(){
        return numbers.size() == length;
    }

    public int getIndex(int number){
        return numbers.indexOf(number);
    }
}

import domain.BallNumber;

import java.util.*;

public class RandomBallNumberGenerator implements BallNumberGenerator {

    @Override
    public BallNumber generate(int length) {
        Set<Integer> numberSet = new HashSet<>();
        while(numberSet.size() < length) {
            numberSet.add((int)(Math.random()*1000)%9+1);
        }
        return new BallNumber(new ArrayList<>(numberSet));
    }
}

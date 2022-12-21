package opponent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Opponent {
    private final List<Integer> answer;

    public Opponent() {
        answer = Collections.unmodifiableList(chooseAnswer());
    }

    public List<Integer> getAnswer() {
        return answer;
    }

    protected List<Integer> chooseAnswer() {
        ArrayList<Integer> possibleNumbers = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            possibleNumbers.add(i);
        }
        Collections.shuffle(possibleNumbers);
        return possibleNumbers.subList(0, 3);
    }

}

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomAnswerMaker implements AnswerMaker {

    @Override
    public String makeAnswer(int length) {
        List<String> numbers = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            numbers.add(String.valueOf(i));
        }
        Collections.shuffle(numbers);

        return numbers.subList(0, length).toString();
    }

}

import java.util.HashMap;

public class Computer {
    private final String answer;
    private final HashMap<Character, Integer> answerPosition;

    public Computer(){
        answer = makeNumber();
        answerPosition = Common.setPositionNumber(answer);
    }

    public String getAnswer() {
        return answer;
    }

    public HashMap<Character, Integer> getAnswerPosition() {
        return answerPosition;
    }

    private String makeNumber() {
        int number = (int) (Math.random() * (999 - 99) + 100);
        String num_string = String.valueOf(number);

        if (!Common.validation(num_string)) {
            return makeNumber();
        }

        return num_string;
    }
}


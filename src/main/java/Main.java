
public class Main {
    static NumberGenerator numberGenerator = new NumberGenerator();
    static Judge judge = new Judge();

    public static void main(String[] args) {
        do {
            start();
        } while (judge.restart());
    }

    public static void start() {
        boolean isCorrect = false;
        int[] answer = numberGenerator.getRandomNumbers();
        while (!isCorrect) {
            isCorrect = judge.judge(answer);
        }
    }

}

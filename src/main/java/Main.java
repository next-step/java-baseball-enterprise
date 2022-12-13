
public class Main {

    static boolean continued;
    static NumberGenerator numberGenerator = new NumberGenerator(3);
    static Judge judge = new Judge();

    public static void main(String[] args) {

        continued = true;
        while (continued) {
            continued = start();
        }

    }

    public static boolean start() {
        boolean isCorrect = false;
        int[] answer = numberGenerator.getRandomNumbers();
        while (!isCorrect) {
            isCorrect = judge.judge(answer);
        }
        return judge.restart();
    }

}

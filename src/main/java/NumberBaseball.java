import java.util.Random;

public class NumberBaseball {
    public static int SIZE = 3;
    public static int[] answer = new int[SIZE];

    public static void main(String[] args) {

        setAnswer();
    }
    public static void setAnswer() {
        while (true) {
            Random random = new Random();
            answer[0] = random.nextInt(9) + 1;
            answer[1] = random.nextInt(9) + 1;
            answer[2] = random.nextInt(9) + 1;
            if (answer[0] != answer[1] && answer[1] != answer[2] && answer[2] != answer[0])
                break;
        }
    }
}

import java.util.Random;
import java.util.Scanner;

public class NumberBaseball {
    public static int SIZE = 3;
    public static int[] answer = new int[SIZE];
    public static int[] guess = new int[SIZE];
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        setAnswer();
        int inputNumber = sc.nextInt();
        setGuess(inputNumber);
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

    public static void setGuess(int inputNumber) {
        guess[0] = inputNumber / 100;
        guess[1] = inputNumber % 100 / 10;
        guess[2] = inputNumber % 10;
    }

}

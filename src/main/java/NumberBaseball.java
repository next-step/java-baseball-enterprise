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

    public static boolean checkGuess() {
        int result = checkSingleDigit(answer, 0) + checkSingleDigit(answer, 1) + checkSingleDigit(answer, 2);
        System.out.println(createMessage(result));


        return true;
    }

    public static String createMessage(int result) {
        if (result == 30) {
            return "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
        }
        if (result != 0) {
            return String.format("%d 스트라이크 %d 볼", result / 10, result % 10);
        }
        return "낫싱";
    }

    public static int checkSingleDigit(int[] answer, int idx) {
        if (answer[idx] == guess[idx]) {
            return 10;
        }
        if (answer[(idx + 1) % 3] == guess[idx] || answer[(idx + 2) % 3] == guess[idx]) {
            return 1;
        }
        return 0;
    }

    public static boolean isRestart() {
        int restart = sc.nextInt();
        if (restart == 1) {
            setAnswer();
            return true;
        }
        return false;
    }

}

import java.util.Scanner;

public class View {
    private Scanner sc = new Scanner(System.in);

    public Integer[] getPlayerInput() {
        System.out.println("숫자를 입력해주세요 : ");
        String input = sc.nextLine();
        String[] numbersInString = input.split("");
        Integer[] numbers = new Integer[3];
        for (int i = 0; i < 3; i++) {
            numbers[i] = Integer.parseInt(numbersInString[i]);
        }
        return numbers;
    }

    public void printScore(int[] scores) {
        String strike = "";
        String ball = "";
        if (scores[0] != 0) strike = scores[0] + "스트라이크";
        if (scores[1] != 0) ball = scores[1] + "볼";
        if (scores[0]+scores[1] != 0) System.out.println(strike + " " + ball);
        if (scores[0]+scores[1] == 0) System.out.println("낫싱");
    }
}

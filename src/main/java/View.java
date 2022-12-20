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

}

package view;

import java.util.Scanner;

public class Console {

    private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String RESTART_OR_EXIT_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private Scanner scanner;

    public Console() {
        scanner = new Scanner(System.in);
    }

    public String getUserInputNumber() {
        System.out.print(INPUT_MESSAGE);
        return scanner.nextLine();
    }

    public String getUserInput() {
        return scanner.nextLine();
    }

    public void printEndMessage() {
        printMessage(END_MESSAGE);
        printMessage(RESTART_OR_EXIT_MESSAGE);
    }

    public void printMessage(String str) {
        System.out.println(str);
    }

}

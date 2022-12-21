package study.baseball;

import java.util.Scanner;
import study.baseball.engine.io.Input;
import study.baseball.engine.io.Output;

public class Console implements Input, Output {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public String input(String message) {
        System.out.print(message);
        return scanner.nextLine();
    }

    @Override
    public void printError(String message) {
        System.out.println("[ERROR] : " + message);
    }

    @Override
    public void printOutput(String message) {
        System.out.println(message);
    }
}

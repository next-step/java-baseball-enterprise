package baseball.IO;

import java.util.Scanner;

public class SystemInputHandler implements InputHandler{
    @Override
    public int getInput() {
        Scanner scanner = new Scanner(System.in);
        return Integer.parseInt(scanner.nextLine());
    }
}

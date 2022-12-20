package baseball;

import java.util.Scanner;

public class Game {

    private Computer computer;
    private Result result;

    public void Start() {
        initializeProps();
        Scanner scanner = new Scanner(System.in);
        int input = 0;

        while(true) {
            System.out.println("숫자를 입력주세요 : ");
            input = scanner.nextInt();

        }
    }

    private void initializeProps() {
        this.computer = new Computer();
        this.result = new Result(0, 0);
    }


}

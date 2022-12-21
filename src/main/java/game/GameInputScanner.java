package game;

import java.util.Scanner;

public class GameInputScanner {
    private final Scanner scanner;
    private final GameInputValidator validator;

    GameInputScanner(){
        this.scanner = new Scanner(System.in);
        this.validator = new GameInputValidator();
    }
    public int[] getGameInput(){
        String input;
        do{
            System.out.print(Message.INPUT_MSG.getMsgStr());
            input = scanner.nextLine().trim();
        }while(!validator.validateGameInput(input));

        return strToIntArr(input);
    }
    private int[] strToIntArr(String input){
        int[] ret = new int[3];
        char[] inputCharArr = input.toCharArray();

        for(int i = 0; i < 3; i++){
            ret[i] = inputCharArr[i] - '0';
        }

        return ret;
    }
    public int getRestartInput(){
        String input;
        do{
            System.out.println(Message.RESTART_MSG.getMsgStr());
            input = scanner.nextLine().trim();
        }while(!validator.validateRestartInput(input));

        return Integer.parseInt(input);
    }
}

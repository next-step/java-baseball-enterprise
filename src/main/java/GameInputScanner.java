import java.util.Scanner;

public class GameInputScanner {
    private final Scanner scanner;

    GameInputScanner(){
        this.scanner = new Scanner(System.in);
    }
    public int[] getGameInput(){
        String input;

        do{
            System.out.print(Message.INPUT_MSG.getMsgStr());
            input = scanner.nextLine().trim();
        }while(!validateGameInput(input));

        return strToIntArr(input);
    }
    private boolean validateGameInput(String input){
        //input 문자열의 길이 & 0이 포함되어 있는지 검사
        if(input.length() != 3 || input.contains("0")){
            System.out.println(Message.INVALID_INPUT_WARNING.getMsgStr());
            return false;
        }

        //input 문자열이 숫자로만 이루어져 있는지 검사
        try{
            Integer.parseInt(input);
        }catch (NumberFormatException numberFormatException){
            System.err.println(Message.INVALID_INPUT_WARNING.getMsgStr());
            return false;
        }

        return true;
    };
    private int[] strToIntArr(String input){
        int[] ret = new int[3];
        char[] inputCharArr = input.toCharArray();

        for(int i = 0; i < 3; i++){
            ret[i] = inputCharArr[i] - '0';
        }

        return ret;
    }

    public int getRestartInput(){
        int cmd = scanner.nextInt();
        return cmd;
    }
}

import java.util.Random;
import java.util.Scanner;

public class Main {
    private static String answer;
    private static boolean isFinish;
    private static Scanner scanner;
    public static void main(String[] args) {
        String input;

        setUp();

        while(!isFinish){
            input = getInput();
        }
    }
    private static void setUp(){
        Random random = new Random();
        isFinish = false;
        answer = String.valueOf(random.nextInt()%1000);
        scanner = new Scanner(System.in);
    }
    private static String getInput(){
        String input;
        do{
            System.out.print(Message.INPUT_MSG);
            input = scanner.nextLine();
        }while(inputCheck(input));

        return input;
    }
    private static boolean inputCheck(String input){
        if(input.length() != 3){
            System.out.println(Message.INVALID_INPUT_WARNING);
            return true;
        }

        try{
            Integer.parseInt(input);
        }catch (NumberFormatException numberFormatException){
            System.out.println(Message.INVALID_INPUT_WARNING);
            return true;
        }

        return false;
    };
}

import java.util.Random;
import java.util.Scanner;

public class Main {
    private static String answer;
    private static boolean isFinish;
    private static Scanner scanner;
    private static InputValidator validator;
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
        validator = new InputValidator();
    }
    private static String getInput(){
        String input;
        do{
            System.out.print(Message.INPUT_MSG.getMsgStr());
            input = scanner.nextLine().trim();
        }while(!validator.validate(input));

        return input;
    }

}

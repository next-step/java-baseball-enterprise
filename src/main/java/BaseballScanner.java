import java.util.ArrayList;
import java.util.Scanner;

public class BaseballScanner {

    static Scanner sc = new Scanner(System.in);

    /*
     * 유저로부터 값을 입력 받고 각 자릿수 숫자들로 구성된 ArrayList를 반환
     */
    public static ArrayList<Integer> getUserInputNumberList() {
        ArrayList<Integer> list = new ArrayList<>();
        boolean inputFlag = false;

        System.out.print("숫자를 입력해주세요: ");
        String userInputStr = sc.nextLine();

        //TODO: 입력값 유효성 검증 로직 필요
        
        for (int i = 0; i < userInputStr.length(); i++) {
            int num = Character.getNumericValue(userInputStr.charAt(i));
            list.add(num);
        }

        return list;
    }
}
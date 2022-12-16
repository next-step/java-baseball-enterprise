import java.util.HashMap;
import java.util.Scanner;

public class BaseballScanner {

    static Scanner sc = new Scanner(System.in);
    static HashMap<Integer, Integer> map = new HashMap<>();

    /*
     * 유저로부터 값을 입력 받고 각 자릿수 숫자들로 구성된 ArrayList를 반환
     */
    public static HashMap<Integer, Integer> getUserInputNumberMap() {
        System.out.print("숫자를 입력해주세요: ");
        String userInputStr = sc.nextLine().trim();

        // TODO: 입력값 유효성 검증 로직 필요

        for (int i = 0; i < userInputStr.length(); i++) {
            int num = Character.getNumericValue(userInputStr.charAt(i));
            map.put(num, i);
        }

        return map;
    }

    public static int getRestartInput() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return Integer.parseInt(sc.nextLine());
    }
}
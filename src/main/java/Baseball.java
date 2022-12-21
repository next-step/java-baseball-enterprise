import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Baseball {

    private static Set<Integer> numbers = new LinkedHashSet<>();
    private static Set<Integer> numbers2 = new LinkedHashSet<>();

    public static void main(String[] args) {
        while (true){
            create3Number();
            playGame();
            int choice = endOrRestart();

            if (choice == 1) continue;
            if (choice == 2) break;
        }
    }

    public static void playGame() {
        String result = "";

        while (!result.equals("3개의 숫자를 모두 맞히셨습니다! 게임 종료")){
            insert3Number();
            result = Result.getResult(numbers, numbers2);
            System.out.println(result);
        }
    }

    /* 게임을 시작하면 1에서 9까지 서로 다른 임의의 수 3개가 생성된다. */
    public static void create3Number() {
        numbers.clear();
        Random random = new Random();

        while (numbers.size() < 3) {
            numbers.add(random.nextInt(9) + 1);
        }
    }

    public static void insert3Number() {
        numbers2.clear();
        Scanner sc = new Scanner(System.in);
        System.out.print("숫자를 입력해주세요 : ");
        String number = sc.nextLine();

        stringToSet(number);
    }

    public static void stringToSet(String number) {
        for (int i = 0; i < number.length(); i++)
        {
            numbers2.add(number.charAt(i) - '0');
        }
    }

    public static int endOrRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();

        return choice;
    }
}

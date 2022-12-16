import java.util.*;

public class Baseball {

    private static Set<Integer> numbers = new LinkedHashSet<>();
    private static Set<Integer> numbers2 = new LinkedHashSet<>();
    public static void main(String[] args) {
        create3Number();
        insert3Number();
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

        for (int i = 0; i < number.length(); i++)
        {
            numbers2.add(number.charAt(i) - '0');
        }
    }
}

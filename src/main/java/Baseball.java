import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

public class Baseball {

    private static Set<Integer> numbers = new LinkedHashSet<>();
    public static void main(String[] args) {
        create3Number();

    }

    /* 게임을 시작하면 1에서 9까지 서로 다른 임의의 수 3개가 생성된다. */
    public static void create3Number() {
        numbers.clear();
        Random random = new Random();

        while (numbers.size() < 3) {
            numbers.add(random.nextInt(10));
        }
    }
}

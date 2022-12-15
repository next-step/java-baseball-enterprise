import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Human {

    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public HashMap<Character, Integer> input() throws IOException {
        System.out.print("숫자를  입력해주세요 : ");
        String input = br.readLine();
        HashMap<Character, Integer> human = new HashMap<>();
        if(!Common.validation(input)) {
            System.out.println("입력이 올바르지 않음.");
            return input();
        }

        Common.setPositionNumber(input, human);
        return human;
    }
}


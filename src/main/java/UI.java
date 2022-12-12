import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UI {

    public String input() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        while (input.trim().length()!=3) {
            System.out.print("숫자를 입력해주세요 : ");
            input = bufferedReader.readLine();
        }
        return input.trim();
    }
}

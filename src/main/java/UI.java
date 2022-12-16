import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class UI {
    public static final String RESTART = "1";
    public static final String EXIT = "2";
    private BufferedReader bufferedReader;

    public UI() {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    public String input() throws IOException {
        System.out.print("숫자를 입력해주세요 : ");
        String input = bufferedReader.readLine();
        return input.trim();
    }

    public void output(int[] result) {
        if (result[0]!=0) {
            System.out.print(result[0] + " 스트라이크 ");
        }
        if (result[1]!=0) {
            System.out.print(result[1] + " 볼 ");
        }
        if (result[0]==0 & result[1] == 0) {
            System.out.print("낫싱");
        }
        System.out.println();
    }

    public String end() throws IOException {
        String input = "";
        while (!Arrays.asList(UI.RESTART, UI.EXIT).contains(input)) {
            System.out.println("게임을 새로 시작하려면 " + UI.RESTART + " 종료하려면 " + UI.EXIT + "를 입력하세요.");
            input = bufferedReader.readLine();
        }
        return input.trim();
    }

    public void close() {
        try {
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

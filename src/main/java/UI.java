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

    public void output(int[] result) {
        if (result[0]!=0) {
            System.out.print(result[0] + " 스트라이크 ");
        }
        if (result[1]!=0) {
            System.out.print(result[1] + " 볼 ");
        }
        if (result[0]==0 & result[1]==0) {
            System.out.print("낫싱");
        }
        System.out.println();
    }
}

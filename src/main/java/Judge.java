import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Judge {

    int total;
    int strike;

    public Judge(int[] numbers) {
        List<Integer> input = getInput();
        int[] result = getStrikeAndBall(numbers, input);
        StringBuilder sb = new StringBuilder();
        if (result[0] > 0) {
            sb.append(result[0] + " 스트라이크 ");
        }
        if (result[1] > 0) {
            sb.append(result[1] + " 볼");
        }
        if (result[0] == 0 && result[1] == 0) {
            sb.append("낫싱");
        }
        System.out.println(sb);
    }

    public List<Integer> getInput() {
        System.out.println("숫자를 입력해주세요 : ");
        Scanner scanner = new Scanner(System.in);
        List<Integer> input = Arrays.stream(scanner.next().split(""))
                .map(s -> Integer.parseInt(s)).collect(Collectors.toList());
        return input;
    }

    public int[] getStrikeAndBall(int[] numbers, List<Integer> input) {
        total = 0;
        strike = 0;
        for (int i = 0; i < numbers.length; i++) {
            count(i, numbers, input);
        }
        return new int[]{strike, total - strike};
    }

    public void count(int idx, int[] numbers, List<Integer> input) {
        if (input.contains(numbers[idx])) {
            total++;
        }
        if (input.get(idx) == numbers[idx]) {
            strike++;
        }
    }

}

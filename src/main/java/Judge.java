import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Judge {

    int total;
    int strike;
    Scanner scanner = new Scanner(System.in);

    // 사용자에게 입력받은 숫자를 리스트 형태로 반환
    public List<Integer> getInput() {
        System.out.print("숫자를 입력해주세요 : ");
        List<Integer> input = Arrays.stream(scanner.next().split(""))
                .map(s -> Integer.parseInt(s)).collect(Collectors.toList());
        return input;
    }

    // 하나의 자리수에서 숫자를 비교하여 스트라이크와 볼 카운트
    public void count(int idx, int[] numbers, List<Integer> input) {
        if (input.contains(numbers[idx])) {
            total++;
        }
        if (input.get(idx) == numbers[idx]) {
            strike++;
        }
    }

    // 세 자리수 비교를 반복하여 스트라이크와 볼 개수 반환
    public int[] getStrikeAndBall(int[] numbers, List<Integer> input) {
        total = 0;
        strike = 0;
        for (int i = 0; i < numbers.length; i++) {
            count(i, numbers, input);
        }
        return new int[]{strike, total - strike};
    }

    // 결과 문구 반환
    public String setOutput(int[] result) {
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
        return sb.toString();
    }

    // 사용자의 입력에 결과를 출력하고 정답 여부 반환
    public boolean judge(int[] numbers) {
        List<Integer> input = getInput();
        int[] result = getStrikeAndBall(numbers, input);
        System.out.println(setOutput(result));
        return result[0] == 3;
    }

    // 사용자의 입력이 정답일 때 다시 사용자에게 입력받아 재시작/종료 여부 반환
    public boolean restart() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int input = Integer.parseInt(scanner.next());
        return input == 1;
    }

}

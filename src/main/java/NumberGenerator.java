import java.util.Random;

public class NumberGenerator {

    int[] numbers = new int[3];
    Random rand = new Random();

    // 1 ~ 9 사이의 임의의 숫자 하나 생성
    public int getRandomNumber() {
        return rand.nextInt(9) + 1;
    }

    // 해당 숫자의 중복 여부 반환
    public boolean isDuplicated(int number) {
        boolean result = false;
        for (int i = 0; i < 3; i++) {
            result = result || numbers[i] == number;
        }
        return result;
    }

    // 중복되지 않을 때까지 랜덤 숫자 생성하여 대입
    public void setNumbers(int idx) {
        int n = getRandomNumber();
        while(isDuplicated(n)) {
            n = getRandomNumber();
        }
        numbers[idx] = n;
    }

    // 세 번 반복하여 임의의 세 자리수를 정수 배열 형태로 반환
    public int[] getRandomNumbers() {
        for (int i = 0; i < 3; i++) {
            setNumbers(i);
        }
        return numbers;
    }

}

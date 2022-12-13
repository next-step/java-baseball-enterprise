import java.util.Random;

public class NumberGenerator {

    static int length;
    static int[] numbers;

    public NumberGenerator(int length) {
        this.length = length > 9 ? 9 : length;
        this.numbers = new int[this.length];
    }

    /*
    * 테스트 필요 사항
    * 1. 세 자리 모두 1에서 9 사이의 숫자인가
    * 2. 세 자리 모두 각각 다른 숫자인가
    */

    Random rand = new Random();

    public int getRandomNumber() {
        return rand.nextInt(9) + 1;
    }

    public boolean isDuplicated(int number) {
        boolean result = false;
        for (int i = 0; i < length; i++) {
            result = result || numbers[i] == number;
        }
        return result;
    }

    public void setNumbers(int idx) {
        int n = getRandomNumber();
        while(isDuplicated(n)) {
            n = getRandomNumber();
        }
        numbers[idx] = n;
    }

    public int[] getRandomNumbers() {
        for (int i = 0; i < length; i++) {
            setNumbers(i);
        }
        return numbers;
    }

}

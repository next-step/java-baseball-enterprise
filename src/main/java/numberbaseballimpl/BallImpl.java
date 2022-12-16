package numberbaseballimpl;

import numberbaseball.Ball;

public class BallImpl implements Ball {

    private final int[] numbers;

    private BallImpl() {
        numbers = new int[3];
    }

    public static Ball from(int number) {
        return null;
    }

    @Override
    public int[] getNumbers() {
        return numbers.clone();
    }
}

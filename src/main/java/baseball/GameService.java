package baseball;

import baseball.domain.Computer;

public class GameService {
    public static final int NUMBERS_SIZE = 3;
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 9;

    private Computer computer;

    public void play() {
        computer = Computer.newInstance();
    }
}

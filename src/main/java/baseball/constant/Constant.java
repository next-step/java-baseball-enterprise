package baseball.constant;

public enum Constant {
    LENGTH(3),
    MIN_RANGE(1),
    MAX_RANGE(9);

    private final int value;

    Constant(int number) {
        this.value = number;
    }

    public int getValue() {
        return value;
    }
}

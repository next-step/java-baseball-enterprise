package baseball.constant;

public enum Command {
    RESTART("1"), QUIT("2");

    private final String value;

    Command(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

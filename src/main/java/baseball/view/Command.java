package baseball.view;

public enum Command {

    NEW_GAME, SHUTDOWN;

    public boolean isNewGame() {
        return this == NEW_GAME;
    }

    public static Command from(String value) {
        if (value.equals("1")) {
            return NEW_GAME;
        }
        if (value.equals("2")) {
            return SHUTDOWN;
        }
        throw new IllegalArgumentException(String.format("[입력값 : %s]에 맞는 명령어가 없습니다.", value));
    }
}

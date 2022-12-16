package baseball.view;

public enum Command {

    NEW_GAME, SHUTDOWN;

    public boolean isNewGame() {
        return this == NEW_GAME;
    }

    public static Command valueOf(int value) {
        if (value == 1) {
            return NEW_GAME;
        }

        if (value == 2) {
            return SHUTDOWN;
        }

        throw new IllegalArgumentException(String.format("[입력값 : %d]에 맞는 명령어가 없습니다.", value));
    }
}

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

        throw new IllegalArgumentException();
    }
}

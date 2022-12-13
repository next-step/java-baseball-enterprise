package baseball.view;

public enum Command {

    NEW_GAME, SHUTDOWN;

    public boolean isNewGame() {
        return this == NEW_GAME;
    }
}

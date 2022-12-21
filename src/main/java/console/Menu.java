package console;

public enum Menu {
    DO_GAME(1),
    EXIT_GAME(2);

    private final int menuNumber;

    Menu(int menuNumber) {
        this.menuNumber = menuNumber;
    }

    public static boolean isDoGame(int menuNumber) {
        return DO_GAME.menuNumber == menuNumber;
    }
}

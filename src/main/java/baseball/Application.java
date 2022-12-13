package baseball;

public class Application {

    public static void main(String[] args) {
        BaseBallGame game = new BaseBallGame(System.out, System.in, "123");
        game.run();
    }
}

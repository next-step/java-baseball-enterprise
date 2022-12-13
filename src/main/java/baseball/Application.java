package baseball;

import baseball.view.View;

public class Application {

    public static void main(String[] args) {
        BaseBallGame game = new BaseBallGame(new View(System.out, System.in), "123");
        game.run();
    }
}

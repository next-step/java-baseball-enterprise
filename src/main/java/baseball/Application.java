package baseball;

import baseball.model.Numbers;
import baseball.model.NumbersGenerator;
import baseball.view.View;

public class Application {

    public static void main(String[] args) {
        View view = new View(System.out, System.in);
        NumbersGenerator numbersGenerator = () -> Numbers.from("123");
        BaseBallGame game = new BaseBallGame(view, numbersGenerator);
        game.run();
    }
}

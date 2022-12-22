package baseball;

public class Engine {
    public void playBall() {
        int flag = 1;
        while (flag == 1) {
            flag = match();
        }
    }

    private int match() {
        Console console = new Console();
        Pitcher pitcher = new Pitcher();
        String target = pitcher.generateNumber();
        batting(console, target);
        return console.endGame();
    }

    private void batting(Console console, String target) {
        int strike = 0;
        int ball;
        Referee referee = new Referee();
        while (strike != 3) {
            String input = console.getInput();
            int[] result = referee.judge(target, input);
            strike = result[0];
            ball = result[1];
            console.printResult(strike, ball);
        }
    }
}

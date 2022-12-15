package baseball.domain;

import java.util.List;

public class GameResult {

    private final int strike;
    private final int ball;

    GameResult(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public static GameResult getResult(List<Integer> player, List<Integer> computer) {
        int strike = getStrike(player, computer).value;
        int ball = getBall(player, computer).value;
        return new GameResult(strike, ball);
    }

    static Data getStrike(List<Integer> player, List<Integer> computer) {
        Data strike = new Data(0);
        for (int i = 0; i < player.size(); i++) {
            int playerDigit = player.get(i);
            int computerDigit = computer.get(i);
            addStrike(playerDigit, computerDigit, strike);
        }
        return strike;
    }

    static Data getBall(List<Integer> player, List<Integer> computer) {
        Data ball = new Data(0);
        for (int i = 0; i < player.size(); i++) {
            int playerDigit = player.get(i);
            int computerDigit = computer.get(i);
            addBall(computer, ball, playerDigit, computerDigit);
        }
        return ball;
    }

    private static void addStrike(int playerDigit, int computerDigit, Data strike) {
        if (playerDigit == computerDigit) {
            strike.addValue();
        }
    }

    private static void addBall(List<Integer> computer, Data ball, int playerDigit, int computerDigit) {
        if (playerDigit != computerDigit && computer.contains(playerDigit)) {
            ball.addValue();
        }
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public boolean isGameContinue(int endOfStrikeCount) {
        return strike != endOfStrikeCount;
    }

    static class Data {

        int value;

        Data(int value) {
            this.value = value;
        }

        void addValue() {
            value++;
        }
    }
}

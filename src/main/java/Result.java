import java.util.Set;

public class Result {

    public static String getResult(Set<Integer> numbers, Set<Integer> numbers2) {
        int ball = CountBallStrike.countBall(numbers, numbers2);
        int strike = CountBallStrike.countStrike(numbers.toArray(new Integer[0]), numbers2.toArray(new Integer[0]));
        ball = ball - strike;

        if (strike == 3) {
            return "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
        }
        return getStringResult(ball, strike);
    }

    public static String getStringResult(int ball, int strike) {
        if (strike > 0 && ball > 0 ) return strike + "스트라이크 " + ball + "볼";

        if (strike > 0) return strike + "스트라이크";

        if (ball > 0) return ball + "볼";

        return "낫싱";
    }
}

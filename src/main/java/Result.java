import java.util.Set;

public class Result {

    public static String getResult(Set<Integer> numbers, Set<Integer> numbers2) {
        int ball = CountBallStrike.countBall(numbers, numbers2);
        int strike = CountBallStrike.countStrike(numbers, numbers2);

        ball = ball - strike;
        String result="낫싱";

        if (strike == 3) {
            result = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
        }
        else if (strike > 0 && ball > 0 ) {
            result = strike + "스트라이크 " + ball + "볼";
        }
        else if (strike > 0) {
            result = strike + "스트라이크";
        }
        else if (ball > 0) {
            result = ball + "볼";
        }

        return result;
    }
}

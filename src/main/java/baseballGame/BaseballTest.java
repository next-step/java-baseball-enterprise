package baseballGame;

public class BaseballTest extends BaseballGame {

    int[] testAnswer() {
        setGame();
        return answer;
    }
    void testSetAnswer(int[] answer) {
        this.answer = answer;
    }
    void testSetUserAnswer(int[] userAnswer) {
        this.userAnswer = userAnswer;
    }
    int testStrike(int[] answer, int[] userAnswer) {
        testSetAnswer(answer);
        testSetUserAnswer(userAnswer);
        evaluate();
        return strike;
    }
    int testBall(int[] answer, int[] userAnswer) {
        testSetAnswer(answer);
        testSetUserAnswer(userAnswer);
        evaluate();
        return ball;
    }
}

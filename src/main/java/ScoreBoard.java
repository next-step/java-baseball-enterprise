import java.util.HashMap;

public class ScoreBoard {
    private Answer answer;
    private int strike = 0;
    private int ball = 0;
    private int nothing = 0;

    public ScoreBoard() {
        this.answer = new Answer();
    }

    private ScoreBoard(Answer answer, int strike, int ball, int nothing) {
        this.answer = answer;
        this.strike = strike;
        this.ball = ball;
        this.nothing = nothing;
    }

    /*
     * 테스트 코드 작성을 위한 static 생성자
     */
    static ScoreBoard forTestCode(Answer answer, int strike, int ball, int nothing) {
        return new ScoreBoard(answer, strike, ball, nothing);
    }

    public Answer getAnswer() {
        return answer;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public int getNothing() {
        return nothing;
    }

    /*
     * 3스트라이크 여부 리턴
     */
    public boolean isThreeStrike() {
        return strike == 3;
    }

    /*
     * 정답 숫자 재설정, 카운트 초기화. 게임 재시작시 사용.
     */
    public void reset() {
        answer = new Answer();
        clearCount();
    }

    /*
     * 유저 입력값에 대해 채점 진행
     */
    public void checkScore(HashMap<Integer, Integer> userInput) {
        clearCount();
        for (Integer i : userInput.keySet()) {
            checkNumber(i, userInput.get(i));
        }
    }

    /*
     * 하나의 숫자에 대해 채점
     */
    private void checkNumber(int num, int idx) {
        if (answer.contains(num)) {
            checkStrikeOrBall(num, idx);
            return;
        }
        nothing++;
    }

    /*
     * 정답에 포함된 숫자에 대해 스트라이크인지 볼인지 확인 후 결과 기록
     */
    private void checkStrikeOrBall(int num, int idx) {
        if (answer.getIndex(num) == idx) {
            strike++;
            return;
        }
        ball++;
    }

    /*
     * 카운트를 초기화함. 유저의 다음 입력값을 새로 받기 위함임.
     */
    private void clearCount() {
        strike = 0;
        ball = 0;
        nothing = 0;
    }
}

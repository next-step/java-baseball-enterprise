import java.util.HashMap;

public class ScoreBoard {
    private HashMap<ScoreType, Integer> scoreMap;
    private Answer answer;
    private HashMap<Integer, Integer> input; // 전역 변수 선언보다 좋은 방법이 있는지 고민해보자.
    
    public ScoreBoard() {
        this.scoreMap = new HashMap<>(){{
            put(ScoreType.S, 0);
            put(ScoreType.B, 0);
            put(ScoreType.N, 0);
        }};
        this.answer = new Answer();
    }

    public int getStrikeCnt() {
        return scoreMap.get(ScoreType.S);
    }

    public int getBallCnt() {
        return scoreMap.get(ScoreType.B);
    }

    public Answer getAnswer() {
        return this.answer;
    }

    /*
     * 정답 숫자 재설정, 카운트 초기화. 게임 재시작시 사용.
     */
    public void reset() {
        answer.resetAnswer();
        clear();
    }

    /*
     * 유저 입력값에 대해 채점 진행
     */
    public void checkScore(HashMap<Integer, Integer> userInput) {
        input = userInput;
        for (Integer i : userInput.keySet()) {
            checkNumber(i);
        }
        printScore();
    }

    /*
     * 하나의 숫자에 대해 채점
     */
    private void checkNumber(int num) {
        if (answer.contains(num)) {
            checkStrikeOrBall(num);
            return;
        }
        addScore(ScoreType.N);
    }

    /*
     * 정답에 포함된 숫자에 대해 스트라이크인지 볼인지 확인 후 결과 기록
     */
    private void checkStrikeOrBall(int num) {
        if (answer.getIndex(num) == input.get(num)) {
            addScore(ScoreType.S);
            return;
        }
        addScore(ScoreType.B);
    }

    /*
     * 채점 결과 터미널에 출력
     */
    private void printScore() {
        String scoreStr = "";
        if (getStrikeCnt() != 0) {
            scoreStr += getStrikeCnt() + " 스트라이크 ";
        }
        if (getBallCnt() != 0) {
            scoreStr += getBallCnt() + " 볼 ";
        }
        System.out.println(scoreStr);
    }

    /*
     * scoreMap에 score count(Strike, Ball, Nothing)를 기록함
     */
    private void addScore(ScoreType type) {
        scoreMap.put(type, scoreMap.get(type) + 1);
    }

    /*
     * scoreMap 카운트를 초기화함. 유저의 다음 입력값을 새로 받기 위함임.
     */
    public void clear() {
        scoreMap.put(ScoreType.S, 0);
        scoreMap.put(ScoreType.B, 0);
        scoreMap.put(ScoreType.N, 0);
    }
}

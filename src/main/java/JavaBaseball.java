import java.util.HashMap;

public class JavaBaseball {
    static final int THREE_STRIKE = 3;
    static final int RESTART_GAME = 1;
    static final int END_GAME = 2;
    
    static Answer answer = new Answer();
    static HashMap<ScoreType, Integer> scoreMap = new HashMap<>();
    static HashMap<Integer, Integer> userInput = new HashMap<>();
    
    static boolean continueGame = true;

    public static void main(String[] args) {
        while (continueGame) {
            runBaseBall();
        }
    }

    /*
     * 숫자야구 실행
     */
    static void runBaseBall() {
        System.out.println(answer);
        initScoreMap();
        while (!isThreeStrike()) {
            initScoreMap();
            userInput = BaseballScanner.getUserInputNumberMap();
            score();
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        askRestart();
    }

    /*
     * 첫 게임 종료 후 재시작 여부 확인
     */
    private static void askRestart() {
        int restartInput = BaseballScanner.getRestartInput();
        if (restartInput == RESTART_GAME) {
            continueGame = true;
            answer.resetAnswer();
            return;
        }
        continueGame = false;
    }

    /*
     * scoreMap을 초기화함
     */
    private static void initScoreMap() {
        scoreMap.put(ScoreType.S, 0);
        scoreMap.put(ScoreType.B, 0);
        scoreMap.put(ScoreType.N, 0);
    }

    /*
     * 유저 입력값에 대해 채점
     */
    static void score() {
        for (Integer i : userInput.keySet()) {
            checkNumber(i);
        }
        printScore();
    }

    /*
     * 채점 결과 터미널에 출력
     */
    private static void printScore() {
        String scoreStr = "";
        if (scoreMap.get(ScoreType.S) != 0) {
            scoreStr += scoreMap.get(ScoreType.S) + " 스트라이크 ";
        }
        if (scoreMap.get(ScoreType.B) != 0) {
            scoreStr += scoreMap.get(ScoreType.B) + " 볼 ";
        }
        System.out.println(scoreStr);
    }

    /*
     * 하나의 숫자에 대해 채점
     */
    static void checkNumber(int num) {
        if (answer.contains(num)) {
            checkStrikeOrBall(num);
            return;
        }
        scoreMap.put(ScoreType.N, scoreMap.get(ScoreType.N) + 1);
    }

    /*
     * 존재가 확인된 숫자에 대해 스트라이크인지 볼인지 확인 후 scoreMap에 반영
     */
    private static void checkStrikeOrBall(int num) {
        if (answer.getIndex(num) == userInput.get(num)) {
            scoreMap.put(ScoreType.S, scoreMap.get(ScoreType.S) + 1);
            return;
        }
        scoreMap.put(ScoreType.B, scoreMap.get(ScoreType.B) + 1);
    }

    /*
     * 3스트라이크(정답) 여부 판단
     */
    private static boolean isThreeStrike() {
        if (scoreMap.get(ScoreType.S) == THREE_STRIKE) {
            return true;
        }
        return false;
    }
}
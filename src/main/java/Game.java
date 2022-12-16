import java.util.HashMap;

public class Game {
    static final int END_GAME = 2;

    private ScoreBoard scoreBoard;
    private HashMap<Integer, Integer> userInput;
    
    private boolean continueGame;

    public Game() {
        this.scoreBoard = new ScoreBoard();
        this.userInput = new HashMap<>();
        this.continueGame = true;
    }

    /*
     * 프로그램 시작
     */
    public void run() {
        while (continueGame) {
            play();
        }
    }

    /*
     * 게임 시작
     */
    public void play() {
        while (scoreBoard.getStrikeCnt() != 3) {
            scoreBoard.clear(); // 최초 실행시엔 의미 없음. 더 좋은 방법이 있는지 고민 필요.
            userInput = Util.getNumberInput();
            scoreBoard.checkScore(userInput);
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        askRestart();
    }

    /*
     * 게임 종료 후 재시작 여부 확인
     * 재시작하는 경우 정답(3자리 숫자) 재설정
     */
    private void askRestart() {
        int restartInput = Util.getRestartInput();
        if (restartInput == END_GAME) {
            continueGame = false;
            return;
        }
        scoreBoard.reset();
    }
}

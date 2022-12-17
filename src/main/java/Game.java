import java.util.HashMap;

public class Game {
    static final int END_GAME = 2;

    private final ScoreBoard scoreBoard;
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
//        System.out.println(scoreBoard.getAnswer());
        while (!scoreBoard.isThreeStrike()) {
            userInput = Util.getNumberInput();
            scoreBoard.checkScore(userInput);
            Util.printScore(scoreBoard);
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        continueGame = askRestart(Util.getRestartInput());
    }

    /*
     * 게임 종료 후 재시작 여부 확인
     * 재시작하는 경우 정답(3자리 숫자) 재설정
     */
    boolean askRestart(int input) {
        if (input == END_GAME) {
            return false;
        }
        scoreBoard.reset();
        return true;
    }
}
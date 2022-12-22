import UI.InputUI;

public class GamePlayer {

    private final int length;
    private String answer;
    private String userInput;

    public GamePlayer(int length) {
        this.length = length;
    }

    public void start() {
        boolean isRestart = false;
        while (!isRestart) {
            playGame();
            String userInput = InputUI.getRestartFlag();
            isRestart = userInput.equals("2");
            System.out.println();
        }
        System.out.println("게임을 완전히 종료합니다.");
    }

    private void playGame() {
        System.out.println("게임을 시작합니다.");
        // 정답 생성
        AnswerMaker answerMaker = new RandomAnswerMaker();
        answer = answerMaker.makeAnswer(length);

        boolean isCorrect = false;
        while (!isCorrect) {
            // 정답 입력
            userInput = InputUI.getAnswerByUser(length);
            isCorrect = compareInputWithAnswer();
        }
    }

    private boolean compareInputWithAnswer() {
        int strikeCnt = 0;
        int ballCnt = 0;
        for (int i = 0; i < userInput.length(); i++) {
            strikeCnt += isStrike(i);
            ballCnt += isBall(i);
        }

        printResult(strikeCnt, ballCnt);
        if (strikeCnt == length) return true;
        return false;
    }

    private int isStrike(int idx) {
        if (answer.indexOf(userInput.charAt(idx)) == idx)
            return 1;
        return 0;
    }

    private int isBall(int idx) {
        if (answer.indexOf(userInput.charAt(idx)) != -1 && answer.indexOf(userInput.charAt(idx)) != idx)
            return 1;
        return 0;
    }

    private void printResult(int strikeCnt, int ballCnt) {
        if (strikeCnt > 0)
            System.out.print(strikeCnt + "스트라이크 ");
        if (ballCnt > 0)
            System.out.print(ballCnt + "볼");
        if (strikeCnt == 0 && ballCnt == 0)
            System.out.print("낫싱");
        System.out.println();

        if (strikeCnt == length) {
            System.out.println(length + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
    }
}

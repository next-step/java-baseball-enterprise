import UI.InputUI;

public class GamePlayer {

    private final int length;

    public GamePlayer(int length) {
        this.length = length;
    }

    public void start() {
        // 정답 생성
        AnswerMaker answerMaker = new RandomAnswerMaker();
        String answer = answerMaker.makeAnswer(length);

        // 정답 입력
        String userInput = InputUI.getAnswerByUser(length);
    }


}

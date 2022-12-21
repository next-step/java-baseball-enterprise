public class GamePlayer {

    private final int length;

    public GamePlayer(int length) {
        this.length = length;
    }

    public void start() {
        // 정답 생성
        AnswerMaker answerMaker = new RandomAnswerMaker();
        String answer = answerMaker.makeAnswer(length);
    }


}

package domain.number_baseball.model;

public interface NumberBaseballOpponentStrategy {
    public void setAnswer();

    public int countBallScore(String input);

    public int countStrikeScore(String input);

    public boolean isAnswer(String input);
}

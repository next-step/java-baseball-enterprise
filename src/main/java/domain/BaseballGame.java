package domain;

public class BaseballGame {

    private final String computerNumbers;

    private GameResult currentGameResult;

    public BaseballGame(String computerNumbers) {
        this.computerNumbers = computerNumbers;
    }

    public GameResult compareNumbers(String userNumbers) {
        currentGameResult = new GameResult();

        for (int i = 0; i < userNumbers.length(); i++) {
            compareNumber(userNumbers.charAt(i), computerNumbers.charAt(i));
        }

        return currentGameResult;
    }

    private void compareNumber(char userNum, char computerNum) {
        if (!computerNumbers.contains(String.valueOf(userNum))) {
            return;
        }

        if (userNum == computerNum) {
            currentGameResult.increaseStrikeCount();
            return;
        }
        currentGameResult.increaseBallCount();
    }

    public boolean isEnd() {
        return currentGameResult.getStrikeCount() == 3;
    }

}

package baseball.view;

import baseball.controller.GameController;
import baseball.controller.request.BaseballNumberRequest;
import baseball.controller.response.GameResponse;

import java.util.Scanner;

public class GameView {

    private final GameController gameController;
    private final Scanner scanner;

    public GameView(GameController gameController) {
        this.gameController = gameController;
        this.scanner = new Scanner(System.in);
    }

    public void playGame() {
        while (gameController.isGamePlaying()) {
            BaseballNumberRequest baseballNumberRequest = getPlayerBaseballInput();
            GameResponse gameResponse = gameController.compareBaseballNumberRequest(baseballNumberRequest);
            printGameResult(gameResponse);
            checkGameEnd(gameResponse);
        }
    }

    private BaseballNumberRequest getPlayerBaseballInput() {
        System.out.print("숫자를 입력해주세요 : ");
        String userInput = scanner.nextLine();
        return new BaseballNumberRequest(userInput);
    }

    private void printGameResult(GameResponse gameResponse) {
        String gameResult = generateGameResult(gameResponse);
        if (gameResult.length() > 0) {
            System.out.println(gameResult);
            return;
        }
        System.out.println("낫싱");
    }

    private String generateGameResult(GameResponse gameResponse) {
        StringBuilder gameResultStringBuilder = new StringBuilder();
        if (gameResponse.getStrike() > 0) {
            gameResultStringBuilder.append(gameResponse.getStrike()).append(" 스트라이크 ");
        }
        if (gameResponse.getBall() > 0) {
            gameResultStringBuilder.append(gameResponse.getBall()).append("볼");
        }
        return gameResultStringBuilder.toString().trim();
    }

    private void checkGameEnd(GameResponse gameResponse) {
        if (gameResponse.isPlaying()) {
            return;
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int userGameRestartOption = Integer.valueOf(scanner.nextLine());
        if (userGameRestartOption == 1) {
            gameController.restartGame();
        }
    }
}

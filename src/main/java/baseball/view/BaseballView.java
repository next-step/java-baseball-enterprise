package baseball.view;

import static baseball.common.BaseballEnum.BASEBALL_NUMBER_LENGTH;
import static baseball.common.BaseballEnum.CONTINUE_THE_GAME;
import static baseball.common.BaseballEnum.FINISH_THE_GAME;

import baseball.controller.BaseballController;
import baseball.dto.BaseballResultDto;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class BaseballView {

    private final Scanner scanner;
    private final BaseballController baseballController;

    public BaseballView(BaseballController baseballController) {
        this.baseballController = baseballController;
        this.scanner = new Scanner(System.in);
    }

    public void startGame() {
        baseballController.startGame();
        while (baseballController.isPlaying()) {
            playGame();
        }
    }

    public void playGame() {
        List<Integer> playerBaseballNumber = getPlayerBaseballNumber();

        BaseballResultDto baseballResultDto = baseballController
                .getBaseballResult(playerBaseballNumber);

        System.out.println(getBaseballResultString(baseballResultDto));
        checkGameStatus(baseballResultDto);
    }

    public void checkGameStatus(BaseballResultDto baseballResultDto) {
        if (baseballResultDto.strikeCount() == BASEBALL_NUMBER_LENGTH) {
            baseballController.finishGame();
            System.out.printf("%d개의 숫자를 모두 맞히셨습니다! 게임 종료 \n", BASEBALL_NUMBER_LENGTH);
            checkContinueGame();
        }
    }

    private void checkContinueGame() {
        System.out.printf("게임을 새로 시작하려면 %d, 종료하려면 %d를 입력하세요.\n",
                CONTINUE_THE_GAME, FINISH_THE_GAME);
        int playerStatusInput = scanner.nextInt();
        try {
            validatePlayerStatusInput(playerStatusInput);
            restartGameIfContinue(playerStatusInput);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            checkContinueGame();
        }
    }

    private void validatePlayerStatusInput(int playerInput) {
        if (playerInput != CONTINUE_THE_GAME && playerInput != FINISH_THE_GAME) {
            throw new IllegalArgumentException(
                    String.format("%d 또는 %d만 입력 가능합니다.", CONTINUE_THE_GAME, FINISH_THE_GAME)
            );
        }
    }

    private void restartGameIfContinue(int playerStatusInput) {
        if (playerStatusInput == CONTINUE_THE_GAME) {
            baseballController.startGame();
        }
    }
    public List<Integer> getPlayerBaseballNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String playerInput = scanner.nextLine();
        try {
            validatePlayerInput(playerInput);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getPlayerBaseballNumber();
        }
        return Arrays.stream(playerInput.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public void validatePlayerInput(String playerInput) {
        isValidLength(playerInput);
        isOnlyNumber(playerInput);
        isNotDuplicated(playerInput);
    }

    private void isValidLength(String playerInput) {
        if (playerInput.length() != BASEBALL_NUMBER_LENGTH) {
            throw new IllegalArgumentException("3자리로 입력해주세요.");
        }
    }

    private void isOnlyNumber(String playerInput) {
        playerInput.chars().mapToObj(x -> (char)x).forEach(this::isNumber);
    }


    private void isNumber(char ch){
        if (!Character.isDigit(ch)) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }
    }

    private void isNotDuplicated(String playerInput) {
        Set<String> playerInputSet = new HashSet<> (Arrays.asList(playerInput.split("")));
        if (playerInputSet.size() != playerInput.length()) {
            throw new IllegalArgumentException("숫자는 중복되지 않게 입력해주세요.");
        }
    }

    private String getBaseballResultString(BaseballResultDto baseballResultDto) {
        String baseballResultString = getStrikeString(baseballResultDto)
                + getBallString(baseballResultDto);
        return baseballResultString.isBlank() ? "낫싱" : baseballResultString;
    }

    private String getStrikeString(BaseballResultDto baseballResultDto) {
        int strikeCount = baseballResultDto.strikeCount();
        return strikeCount != 0 ? String.format("%d 스트라이크 ", strikeCount) : "";
    }

    private String getBallString(BaseballResultDto baseballResultDto) {
        int ballCount = baseballResultDto.ballCount();
        return ballCount != 0 ? String.format("%d 볼", ballCount) : "";
    }
}
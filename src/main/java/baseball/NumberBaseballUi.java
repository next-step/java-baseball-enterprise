package baseball;

import baseball.dto.StrikeBallCountDto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberBaseballUi {

    private BufferedReader reader;
    private final PlayerInputValidator validator;

    public NumberBaseballUi(PlayerInputValidator validator) {
        this.validator = validator;
    }

    public List<Integer> readPlayerBaseballNumber() throws IOException {
        reader = new BufferedReader(new InputStreamReader(System.in));
        String playerInput = null;
        while ((playerInput = readPlayerBaseballNumberString()) == null) {}
        reader.close();
        int playerBaseballNumber = Integer.parseInt(playerInput);
        return extractDigitsInOrder(playerBaseballNumber);
    }

    public int readGameRestartInput() throws IOException{
        reader = new BufferedReader(new InputStreamReader(System.in));
        String playerInput = null;
        while ((playerInput = readGameRestartInputString()) == null) {}
        reader.close();
        return Integer.parseInt(playerInput);
    }

    public void printStrikeBallCount(StrikeBallCountDto strikeBallCountDto) {
        if (strikeBallCountDto.getStrikeCnt() == 0 && strikeBallCountDto.getBallCnt() == 0) {
            System.out.println("낫싱");
            return;
        }
        printStrikeCount(strikeBallCountDto.getStrikeCnt());
        if (strikeBallCountDto.getBallCnt() == 0) {
            System.out.println();
            return;
        }
        printBallCount(strikeBallCountDto.getBallCnt());
    }

    public void printSuccessMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private void printStrikeCount(int strikeCnt) {
        if (strikeCnt == 0) {
            return;
        }
        System.out.print(strikeCnt + " 스트라이크 ");
    }

    private void printBallCount(int ballCnt) {
        if (ballCnt == 0) {
            return;
        }
        System.out.println(ballCnt + " 볼");
    }

    private String readPlayerBaseballNumberString() throws IOException {
        System.out.print("숫자를 입력해주세요: ");
        String playerInputString = reader.readLine();
        if (playerInputString != null) {
            playerInputString = playerInputString.trim();
        }
        if (!validator.validateBaseballNumber(playerInputString)) {
            System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            return null;
        }
        return playerInputString;
    }

    private String readGameRestartInputString() throws IOException {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String playerInputString = reader.readLine();
        if (playerInputString != null) {
            playerInputString = playerInputString.trim();
        }
        if (!validator.validateRestartInput(playerInputString)) {
            System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            return null;
        }
        return playerInputString;
    }

    private List<Integer> extractDigitsInOrder(int playerBaseballNumber) {
        List<Integer> digits = new ArrayList<>();
        while (playerBaseballNumber != 0) {
            digits.add(playerBaseballNumber % 10);
            playerBaseballNumber /= 10;
        }
        Collections.reverse(digits);
        return digits;
    }

}

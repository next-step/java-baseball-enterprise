package baseball.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class BaseballView {

    private static final int BASEBALL_NUMBER_LENGTH = 3;
    private final BufferedReader bufferedReader;

    public BaseballView() {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    public List<Integer> getPlayerBaseballNumber() throws IOException {
        System.out.print("숫자를 입력해주세요 : ");
        String playerInput = bufferedReader.readLine();
        validatePlayerInput(playerInput);
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
}
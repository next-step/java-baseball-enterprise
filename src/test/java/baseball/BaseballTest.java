package baseball;

import baseball.domain.Computer;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

public class BaseballTest {
    @ParameterizedTest
    @CsvSource(value = {"1,2,3:1,2,3:3 스트라이크", "3,4,7:3,5,7:2 스트라이크", "4,8,7:1,3,7:1 스트라이크"}, delimiter = ':')
    @DisplayName("스트라이크 확인")
    public void strike(String answer, String input, String result) {
        validateResult(answer, input, result);
    }

    @ParameterizedTest
    @CsvSource(value = {"3,1,2:1,2,3:3볼", "7,3,1:3,5,7:2볼", "4,8,3:1,3,7:1볼"}, delimiter = ':')
    @DisplayName("볼 확인")
    public void ball(String answer, String input, String result) {
        validateResult(answer, input, result);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,3,9:1,2,3:1 스트라이크 1볼", "5,1,2:5,3,1:1 스트라이크 1볼"}, delimiter = ':')
    @DisplayName("스트라이크 + 볼 확인")
    public void strikeAndBall(String answer, String input, String result) {
        validateResult(answer, input, result);
    }

    @ParameterizedTest
    @CsvSource(value = {"4,1,3:6,7,9:낫싱", "5,1,2:3,4,6:낫싱"}, delimiter = ':')
    @DisplayName("낫싱 확인")
    public void nothing(String answer, String input, String result) {
        validateResult(answer, input, result);
    }

    private List<Integer> stringToIntegerList(String str) {
        List<Integer> resultList = new ArrayList<>();
        String[] splitString = str.split(",");

        for(int i = 0 ; i < splitString.length ; i++) {
           resultList.add(Integer.parseInt(splitString[i]));
        }

        return resultList;
    }

    private void validateResult(String answer, String input, String expected) {
        Computer computer = new Computer(stringToIntegerList(answer));
        Assertions.assertThat(computer.calculateResult(stringToIntegerList(input))
                .exportResultString())
                .isEqualTo(expected);
    }
}

package baseball.model;

import static assertions.JudgementsAssert.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RefereeTest {

    @DisplayName("결과를 판결한다.")
    @Test
    void judgeNothing() {
        Referee referee = new Referee(Numbers.from("123"));

        Judgements actual = referee.judge(Numbers.from("456"));
        assertThat(actual).hasStrike(0).hasBall(0);

        actual = referee.judge(Numbers.from("145"));
        assertThat(actual).hasStrike(1).hasBall(0);
    }

    @DisplayName("1스트라이크로 판결한다.")
    @ParameterizedTest
    @CsvSource({"123, 145", "123, 425", "123, 453"})
    void judgeOneStrike(String rightNumbers, String inputNumbers) {
        Referee referee = new Referee(Numbers.from(rightNumbers));

        Judgements actual = referee.judge(Numbers.from(inputNumbers));

        assertThat(actual).hasStrike(1).hasBall(0);
    }

    @DisplayName("두번째 자리의 숫자만 같은 경우 1스트라이크로 판결한다.")
    @Test
    void judgeOneStrikeSecondDigit() {
        Referee referee = new Referee(Numbers.from("123"));

        Judgements actual = referee.judge(Numbers.from("425"));

        assertThat(actual).hasStrike(1).hasBall(0);
    }

    @DisplayName("세번째 자리의 숫자만 같은 경우 1스트라이크로 판결한다.")
    @Test
    void judgeOneStrikeThirdDigit() {
        Referee referee = new Referee(Numbers.from("123"));

        Judgements actual = referee.judge(Numbers.from("453"));

        assertThat(actual).hasStrike(1).hasBall(0);
    }

    @DisplayName("2스트라이크로 판결한다.")
    @Test
    void judgeTwoStrike() {
        Numbers rightNumbers = Numbers.from("123");
        Numbers inputNumbers = Numbers.from("124");
        Referee referee = new Referee(rightNumbers);

        Judgements actual = referee.judge(inputNumbers);

        assertThat(actual).hasStrike(2).hasBall(0);
    }

    @DisplayName("1볼로 판결한다.")
    @Test
    void judgeOneBall() {
        Numbers rightNumbers = Numbers.from("123");
        Numbers inputNumbers = Numbers.from("415");
        Referee referee = new Referee(rightNumbers);

        Judgements actual = referee.judge(inputNumbers);

        assertThat(actual).hasStrike(0).hasBall(1);
    }

    @DisplayName("2볼로 판결한다.")
    @Test
    void judgeTwoBall() {
        Numbers rightNumbers = Numbers.from("123");
        Numbers inputNumbers = Numbers.from("215");
        Referee referee = new Referee(rightNumbers);

        Judgements actual = referee.judge(inputNumbers);

        assertThat(actual).hasStrike(0).hasBall(2);
    }

    @DisplayName("3볼로 판결한다.")
    @Test
    void judgeThreeBall() {
        Numbers rightNumbers = Numbers.from("123");
        Numbers inputNumbers = Numbers.from("312");
        Referee referee = new Referee(rightNumbers);

        Judgements actual = referee.judge(inputNumbers);

        assertThat(actual).hasStrike(0).hasBall(3);
    }

    @DisplayName("1스트라이크 2볼로 판결한다.")
    @ParameterizedTest
    @CsvSource({"123, 132", "456, 654", "789, 879"})
    void judgeTwoBallAndOneStrike(String rightNumbersText, String inputNumbersText) {
        Numbers rightNumbers = Numbers.from(rightNumbersText);
        Numbers inputNumbers = Numbers.from(inputNumbersText);
        Referee referee = new Referee(rightNumbers);

        Judgements actual = referee.judge(inputNumbers);

        assertThat(actual).hasStrike(1).hasBall(2);
    }

    @DisplayName("3스트라이크로 판결한다.")
    @Test
    void judgeThreeStrike() {
        Numbers rightNumbers = Numbers.from("123");
        Numbers inputNumbers = Numbers.from("123");
        Referee referee = new Referee(rightNumbers);

        Judgements actual = referee.judge(inputNumbers);

        assertThat(actual).hasStrike(3).hasBall(0);
    }
}

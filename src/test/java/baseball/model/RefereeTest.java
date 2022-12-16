package baseball.model;

import static assertions.JudgementsAssert.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RefereeTest {

    @DisplayName("낫싱으로 판결한다.")
    @Test
    void judgeNothing() {
        Numbers rightNumbers = Numbers.from("123");
        Numbers inputNumbers = Numbers.from("456");
        Referee referee = new Referee(rightNumbers);

        Judgements actual = referee.judge(inputNumbers);

        assertThat(actual).hasStrike(0).hasBall(0);
    }

    @DisplayName("1스트라이크로 판결한다.")
    @ParameterizedTest
    @CsvSource({"123, 145", "123, 425", "123, 453"})
    void judgeOneStrike(String rightNumbersText, String inputNumbersText) {
        Numbers rightNumbers = Numbers.from(rightNumbersText);
        Numbers inputNumbers = Numbers.from(inputNumbersText);
        Referee referee = new Referee(rightNumbers);

        Judgements actual = referee.judge(inputNumbers);

        assertThat(actual).hasStrike(1).hasBall(0);
    }

    @DisplayName("2스트라이크로 판결한다.")
    @ParameterizedTest
    @CsvSource({"123, 124", "456, 156", "789, 759"})
    void judgeTwoStrike(String rightNumbersText, String inputNumbersText) {
        Numbers rightNumbers = Numbers.from(rightNumbersText);
        Numbers inputNumbers = Numbers.from(inputNumbersText);
        Referee referee = new Referee(rightNumbers);

        Judgements actual = referee.judge(inputNumbers);

        assertThat(actual).hasStrike(2).hasBall(0);
    }

    @DisplayName("1볼로 판결한다.")
    @ParameterizedTest
    @CsvSource({"123, 415", "123, 451", "123, 245", "123, 452", "123, 345", "123, 435"})
    void judgeOneBall(String rightNumbersText, String inputNumbersText) {
        Numbers rightNumbers = Numbers.from(rightNumbersText);
        Numbers inputNumbers = Numbers.from(inputNumbersText);
        Referee referee = new Referee(rightNumbers);

        Judgements actual = referee.judge(inputNumbers);

        assertThat(actual).hasStrike(0).hasBall(1);
    }

    @DisplayName("2볼로 판결한다.")
    @ParameterizedTest
    @CsvSource({"123, 215", "123, 251"})
    void judgeTwoBall(String rightNumbersText, String inputNumbersText) {
        Numbers rightNumbers = Numbers.from(rightNumbersText);
        Numbers inputNumbers = Numbers.from(inputNumbersText);
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

package baseball;

import baseball.domain.StrikeBallCount;
import baseball.view.OutputView;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

public class OutputViewTest {
    OutputView outputView = new OutputView();
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @BeforeEach
    public void setOutStreams() {
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(System.out);
        outputStream.reset();
    }

    @DisplayName("모든 StrikeBallCount에 대해 제대로 출력하는지 확인한다.")
    @ParameterizedTest
    @EnumSource(StrikeBallCountCombination.class)
    void printResultTest(StrikeBallCountCombination countCombination) {
        StrikeBallCount sb = countCombination.getStrikeBallCount();
        outputView.printResult(sb);
        assertThat(outputStream.toString()
                .trim()).isEqualTo(countCombination.result);
    }
}


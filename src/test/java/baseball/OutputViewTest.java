package baseball;

import baseball.domain.StrikeBallCount;
import baseball.view.OutputView;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

public class OutputViewTest {
    OutputView outputView = new OutputView();
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    private enum BallCounts {
        count_00(0, 0, "낫싱"),
        count_01(0, 1, "1볼"),
        count_02(0, 2, "2볼"),
        count_03(0, 3, "3볼"),
        count_10(1, 0, "1스트라이크"),
        count_11(1, 1, "1스트라이크 1볼"),
        count_12(1, 2, "1스트라이크 2볼"),
        count_20(2, 0, "2스트라이크"),
        count_21(2, 1, "2스트라이크 1볼"),
        count_30(3, 0, "3스트라이크");
        private final int strikes;
        private final int balls;
        private final String result;

        BallCounts(int strikes, int balls, String result) {
            this.strikes = strikes;
            this.balls = balls;
            this.result = result;
        }
    }

    @BeforeEach
    public void setOutStreams() {
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(System.out);
        outputStream.reset();
    }

    @ParameterizedTest
    @EnumSource(BallCounts.class)
    void printResultTest(BallCounts ballcounts) {
        StrikeBallCount sb = new StrikeBallCount();
        setStrikeBallCount(sb, ballcounts.strikes, ballcounts.balls);
        outputView.printResult(sb);
        assertThat(outputStream.toString()
                .trim()).isEqualTo(ballcounts.result);
    }

    void setStrikeBallCount(StrikeBallCount sb, int strikes, int balls) {
        sb.resetCounts();
        for (int i = 0; i < strikes; i++) {
            sb.addStrikeCount();
        }
        for (int i = 0; i < balls; i++) {
            sb.addBallCount();
        }
    }
}


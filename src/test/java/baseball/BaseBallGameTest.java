package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.model.NumbersGenerator;
import baseball.testdoubles.SpyOutputStream;
import baseball.testdoubles.StubInputStream;
import baseball.testdoubles.StubNumbersGenerator;
import baseball.view.View;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;

class BaseBallGameTest {

    @Test
    void baseBallGameScenario() {
        SpyOutputStream spyOutputStream = new SpyOutputStream();
        StubInputStream inputStream = new StubInputStream("678", "123", "352", "345", "1", "123", "2");
        View view = new View(new PrintStream(spyOutputStream), inputStream);
        NumbersGenerator numbersGenerator = new StubNumbersGenerator("345", "123");
        BaseBallGame game = new BaseBallGame(view, numbersGenerator);

        game.run();

        assertThat(spyOutputStream.getPrintedTexts())
                .containsExactly(
                        "숫자를 입력하세요 : ",
                        "낫싱",
                        "숫자를 입력하세요 : ",
                        "1볼",
                        "숫자를 입력하세요 : ",
                        "1스트라이크 1볼",
                        "숫자를 입력하세요 : ",
                        "3스트라이크",
                        "3개의 숫자를 모두 맞히셨습니다! 게임종료",
                        "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.",
                        "숫자를 입력하세요 : ",
                        "3스트라이크",
                        "3개의 숫자를 모두 맞히셨습니다! 게임종료",
                        "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."
                );
    }
}

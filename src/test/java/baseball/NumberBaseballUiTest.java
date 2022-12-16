package baseball;

import baseball.dto.StrikeBallCountDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class NumberBaseballUiTest {

    @Test
    void readPlayerBaseballNumber_성공1() throws IOException {
        String input = "123";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        NumberBaseballUi numberBaseballUi = new NumberBaseballUi(new PlayerInputValidator());

        assertThat(numberBaseballUi.readPlayerBaseballNumber()).containsExactly(1, 2, 3);
    }

    @Test
    void readPlayerBaseballNumber_성공2() throws IOException {
        String input = "468";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        NumberBaseballUi numberBaseballUi = new NumberBaseballUi(new PlayerInputValidator());

        assertThat(numberBaseballUi.readPlayerBaseballNumber()).containsExactly(4, 6, 8);
    }

    @Test
    void readPlayerBaseballNumber_실패1() throws IOException {
        String input = "111\n123";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        NumberBaseballUi numberBaseballUi = new NumberBaseballUi(new PlayerInputValidator());

        String expectedOutput = "숫자를 입력해주세요: 잘못된 입력입니다. 다시 입력해주세요.\n숫자를 입력해주세요: ";

        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        assertThat(numberBaseballUi.readPlayerBaseballNumber()).containsExactly(1, 2, 3);
        assertThat(out.toString()).hasToString(expectedOutput);
    }

    @Test
    void readGameRestartInput_성공1() throws IOException {
        String input = "1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        NumberBaseballUi numberBaseballUi = new NumberBaseballUi(new PlayerInputValidator());

        assertThat(numberBaseballUi.readGameRestartInput()).isEqualTo(1);
    }

    @Test
    void readGameRestartInput_성공2() throws IOException {
        String input = "2";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        NumberBaseballUi numberBaseballUi = new NumberBaseballUi(new PlayerInputValidator());

        assertThat(numberBaseballUi.readGameRestartInput()).isEqualTo(2);
    }

    @Test
    void readGameRestartInput_실패1() throws IOException {
        String input = "asd\n1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        NumberBaseballUi numberBaseballUi = new NumberBaseballUi(new PlayerInputValidator());

        String expectedOutput = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n" +
                "잘못된 입력입니다. 다시 입력해주세요.\n" +
                "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n";

        assertThat(numberBaseballUi.readGameRestartInput()).isEqualTo(1);
        assertThat(out.toString()).hasToString(expectedOutput);
    }

    @Test
    void printStrikeBallCount() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        NumberBaseballUi numberBaseballUi = new NumberBaseballUi(new PlayerInputValidator());

        String expectedOutput = "낫싱\n" +
                "1 스트라이크 \n" +
                "2 볼\n" +
                "1 스트라이크 1 볼\n" +
                "3 스트라이크\n" +
                "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n";

        StrikeBallCountDto strikeBallCountDto1 = new StrikeBallCountDto(0, 0);
        StrikeBallCountDto strikeBallCountDto2 = new StrikeBallCountDto(1, 0);
        StrikeBallCountDto strikeBallCountDto3 = new StrikeBallCountDto(0, 2);
        StrikeBallCountDto strikeBallCountDto4 = new StrikeBallCountDto(1, 1);
        StrikeBallCountDto strikeBallCountDto5 = new StrikeBallCountDto(3, 0);

        numberBaseballUi.printStrikeBallCount(strikeBallCountDto1);
        numberBaseballUi.printStrikeBallCount(strikeBallCountDto2);
        numberBaseballUi.printStrikeBallCount(strikeBallCountDto3);
        numberBaseballUi.printStrikeBallCount(strikeBallCountDto4);
        numberBaseballUi.printStrikeBallCount(strikeBallCountDto5);

        assertThat(out.toString()).hasToString(expectedOutput);
    }
}
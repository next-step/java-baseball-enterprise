package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class BaseBallGameTest {

    static class SpyOutputStream extends OutputStream {

        private final List<Byte> bytes = new ArrayList<>();

        @Override
        public void write(int b) throws IOException {
            bytes.add((byte) b);
        }

        public String[] getPrintedTexts() {
            byte[] data = new byte[bytes.size()];

            for (int i = 0; i < bytes.size(); i++) {
                data[i] = bytes.get(i);
            }

            return new String(data, StandardCharsets.UTF_8).split("\n");
        }
    }

    static class StubInputStream extends InputStream {

        private final InputStream inputStream;

        public StubInputStream(String... text) {
            String texts = String.join("\n", text);
            inputStream = new ByteArrayInputStream(texts.getBytes());
        }

        @Override
        public int read() throws IOException {
            return inputStream.read();
        }
    }

    @Test
    void baseBallGameScenario() {
        SpyOutputStream spyOutputStream = new SpyOutputStream();
        StubInputStream inputStream = new StubInputStream("678", "123", "352", "345", "1", "345", "2");
        BaseBallGame game = new BaseBallGame(new PrintStream(spyOutputStream), inputStream, "345");

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

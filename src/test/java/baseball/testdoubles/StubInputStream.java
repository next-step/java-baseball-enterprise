package baseball.testdoubles;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class StubInputStream extends InputStream {

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

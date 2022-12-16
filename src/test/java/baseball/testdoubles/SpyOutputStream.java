package baseball.testdoubles;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class SpyOutputStream extends OutputStream {

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

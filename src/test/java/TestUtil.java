import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

public class TestUtil {

    public static Scanner getScanner(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());

        return new Scanner(in);
    }

}

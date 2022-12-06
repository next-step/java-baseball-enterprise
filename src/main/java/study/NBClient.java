package study;

public class NBClient {
    private static final int NUM_LENGTH = 3;

    public static void main(String[] args) {
        NumberBaseball nb = new NumberBaseball();
        nb.set_random_number(NUM_LENGTH);
    }
}
